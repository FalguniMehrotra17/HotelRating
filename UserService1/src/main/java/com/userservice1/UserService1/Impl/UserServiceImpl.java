package com.userservice1.UserService1.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice1.UserService1.Hotel;
import com.userservice1.UserService1.Rating;
import com.userservice1.UserService1.Rating;
import com.userservice1.UserService1.User;
import com.userservice1.UserService1.Services.UserService;
import com.userservice1.UserService1.exception.ResourceNotFoundException;
import com.userservice1.UserService1.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    private Logger logger = LoggerFactory.getLogger(UserService.class);   

    @Override
    public User save_user(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));
        
        // Fetch by Rating Service 
        Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8082/ratings/user/"+user.getUserId(),Rating[].class);
        logger.info("{}",ratingsOfUser);
        List<Rating> ratings=Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList=ratings.stream().map(rating->{
        	//api call to hotel service to get the hotel
        	//http://localhost:8084/hotels/a05ac3d8-999d-4512-8e2f-efc845f6e24b
        	ResponseEntity<Hotel> responseEntity=restTemplate.getForEntity("http://localhost:8084/hotels/"+rating, Hotel.class);
        	Hotel hotel=responseEntity.getBody();
        	logger.info("response status code",responseEntity.getStatusCode());
        	//set the hotel to rating
        	rating.setHotel(hotel);
        	//return the rating
        	return rating;
        	
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        
        //user.setRatings(ratings);  // Ensure User class has a setter for ratings
        return user;
    }
} 

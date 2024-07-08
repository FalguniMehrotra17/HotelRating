package com.example.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entities.Rating;
import com.example.rating.repository.RatingRepository;
import com.example.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
    
    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repository.findByUserId(userId);
    }
    
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}

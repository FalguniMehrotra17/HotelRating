package com.example.rating.services;

import java.util.List;

import com.example.rating.entities.Rating;



public interface RatingService {
	Rating create(Rating rating); 
	List<Rating> getRatings();
	List<Rating> getRatingsByUserId(String userId);
	List<Rating> getRatingsByHotelId(String hotelId);
	

}

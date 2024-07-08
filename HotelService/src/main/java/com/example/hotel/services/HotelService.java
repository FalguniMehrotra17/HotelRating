package com.example.hotel.services;

import java.util.List;

import com.example.hotel.entities.Hotel;


public interface HotelService {
	Hotel save_hotel(Hotel hotel); 
	List<Hotel> getAllHotel();
	Hotel get (String Id);
	//Object getAll();

}

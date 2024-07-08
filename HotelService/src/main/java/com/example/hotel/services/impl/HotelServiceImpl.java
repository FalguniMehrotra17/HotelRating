package com.example.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.entities.Hotel;
import com.example.hotel.repositories.HotelRepository;
import com.example.hotel.services.HotelService;
import com.userservice1.UserService1.exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	
	private HotelRepository hotelrepository;

	@Override
	public Hotel save_hotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelrepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelrepository.findAll();
	}

	@Override
	public Hotel get(String Id) {
		// TODO Auto-generated method stub
		return hotelrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !!"));
	}

}

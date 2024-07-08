package com.example.hotel.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.entities.Hotel;
import com.example.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelservice;
	
	public HotelController() {
        System.out.println("UserController loaded");
    }
	
  @PostMapping
  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
	  hotel.setId(UUID.randomUUID().toString());
	  return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.save_hotel(hotel));
  } 
	  @GetMapping("/{hotelId}")
	  public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
		  return ResponseEntity.status(HttpStatus.OK).body(hotelservice.get(hotelId));
  }
	  
	  @GetMapping
	  public ResponseEntity<List<Hotel>> getAll(){
		  return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getAllHotel());
		  
	  }
}

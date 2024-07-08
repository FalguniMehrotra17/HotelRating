package com.userservice1.UserService1.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice1.UserService1.User;
import com.userservice1.UserService1.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	 public UserController() {
	        System.out.println("UserController loaded");
	    }
	 
	@PostMapping
 public ResponseEntity<User> createUser(@RequestBody User user){
	 User user1=userservice.save_user(user);
	 return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	 
 }
	
	@GetMapping("/{userId}")
	 public ResponseEntity<User> getSingleUser(@PathVariable  String userId){
		 User user=userservice.getUser(userId);
		 return ResponseEntity.ok(user) ;
		 
	 }
	
	@GetMapping
	public ResponseEntity<List<User>>getAllUser(){
		List<User> allUser= userservice.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	
}


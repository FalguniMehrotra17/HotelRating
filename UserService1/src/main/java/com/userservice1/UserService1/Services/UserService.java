package com.userservice1.UserService1.Services;

import java.util.List;

import com.userservice1.UserService1.User;

public interface UserService {
	User save_user(User user); 
	List<User> getAllUser();
	User getUser(String userId);
	

}

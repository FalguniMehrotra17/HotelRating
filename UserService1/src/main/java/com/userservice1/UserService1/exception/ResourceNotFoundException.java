package com.userservice1.UserService1.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource Not Found on server !!");
	}
	public ResourceNotFoundException(String message) {
		super("message");
	}

}

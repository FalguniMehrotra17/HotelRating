package com.userservice1.UserService1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.userservice1.UserService1.exception.payload.ApiResponse;
//import com.userservice1.UserService1.payload.ApiResponse;
//import com.userservice1.UserService1.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage(); 
        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true) // Assuming this should be false for a not found scenario
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Add more exception handlers as needed for other custom exceptions

}

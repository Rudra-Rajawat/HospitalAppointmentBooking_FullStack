package com.example.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.BookingNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BookingNotFound.class)
	ResponseEntity<String> handleResourceNotFoundException(BookingNotFound ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
 
}

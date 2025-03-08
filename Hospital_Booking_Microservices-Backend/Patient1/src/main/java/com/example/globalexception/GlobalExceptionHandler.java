package com.example.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.PatientNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PatientNotFound.class)
	ResponseEntity<String> handleResourceNotFoundException(PatientNotFound ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}

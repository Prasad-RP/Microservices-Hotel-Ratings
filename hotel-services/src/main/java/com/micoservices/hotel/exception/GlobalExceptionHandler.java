package com.micoservices.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.micoservices.hotel.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex) {
		com.micoservices.hotel.dto.ApiResponse response = new ApiResponse(ex.getMessage(), false, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
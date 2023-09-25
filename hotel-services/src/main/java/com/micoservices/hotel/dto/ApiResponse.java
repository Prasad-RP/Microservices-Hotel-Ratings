package com.micoservices.hotel.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	public ApiResponse(String message, boolean success, HttpStatus responseStatus) {
		super();
		this.message = message;
		this.success = success;
		this.responseStatus = responseStatus;
	}

	public ApiResponse() {
		super();
	}

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	private String message;

	private boolean success;

	private HttpStatus responseStatus;

	private final LocalDateTime timestamp = LocalDateTime.now();

}

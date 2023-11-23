package com.micoservices.user.dto;

import java.util.List;

import lombok.Data;

@Data
public class User {
	private String userId;

	private String userName;

	private String userEmail;

	private String about;
	
	private List<Ratings> ratings;
}

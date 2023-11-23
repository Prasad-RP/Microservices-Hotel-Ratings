package com.micoservices.user.dto;

import lombok.Data;

@Data
public class Ratings {

	private String ratingId;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;

	private Hotel hotel;
}

package com.micoservices.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "rating_master")
public class RatingMaster {

	@Id
	private String ratingId;

	@Field(name = "user_id")
	private String userId;

	@Field(name = "hotel_id")
	private String hotelId;

	@Field(name = "ratings")
	private Integer rating;

	@Field(name = "feedback")
	private String feedback;
}

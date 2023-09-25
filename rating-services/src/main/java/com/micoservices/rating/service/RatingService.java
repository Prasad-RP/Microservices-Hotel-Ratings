package com.micoservices.rating.service;

import java.util.List;

import com.micoservices.rating.entity.RatingMaster;

public interface RatingService {

	RatingMaster save(RatingMaster master);

	RatingMaster update(RatingMaster master);

	RatingMaster getById(String ratingId);

	List<RatingMaster> getAll();

	Boolean delete(String ratingId);

	Boolean existbyId(String ratingId);

	// Additional Methods
	List<RatingMaster> getRatingsByUser(String userId);

	List<RatingMaster> getRatingsByHotel(String hotelId);

}

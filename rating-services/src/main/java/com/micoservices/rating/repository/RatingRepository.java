package com.micoservices.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.micoservices.rating.entity.RatingMaster;

@Repository
public interface RatingRepository extends MongoRepository<RatingMaster, String> {

	List<RatingMaster> findByUserId(String userId);

	List<RatingMaster> findByHotelId(String hotelId);
}

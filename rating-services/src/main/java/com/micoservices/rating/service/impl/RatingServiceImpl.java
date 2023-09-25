package com.micoservices.rating.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micoservices.rating.entity.RatingMaster;
import com.micoservices.rating.exception.ResourceNotFoundException;
import com.micoservices.rating.repository.RatingRepository;
import com.micoservices.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

	private final RatingRepository ratingRepository;

	@Override
	public RatingMaster save(RatingMaster master) {

		return ratingRepository.save(master);
	}

	@Override
	public RatingMaster update(RatingMaster master) {
		existbyId(master.getRatingId());
		return ratingRepository.save(master);
	}

	@Override
	public RatingMaster getById(String ratingId) {
		return ratingRepository.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating", "Rating ID ", ratingId));
	}

	@Override
	public List<RatingMaster> getAll() {
		return ratingRepository.findAll();
	}

	@Override
	public Boolean delete(String ratingId) {
		existbyId(ratingId);
		ratingRepository.deleteById(ratingId);
		return true;
	}

	@Override
	public Boolean existbyId(String ratingId) {
		if (ratingRepository.existsById(ratingId))
			return true;
		else
			throw new ResourceNotFoundException("Rating", "Rating ID", ratingId);
	}

	@Override
	public List<RatingMaster> getRatingsByUser(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<RatingMaster> getRatingsByHotel(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}

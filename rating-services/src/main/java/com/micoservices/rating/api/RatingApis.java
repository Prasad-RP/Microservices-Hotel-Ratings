package com.micoservices.rating.api;

import static com.micoservices.rating.enums.ApiKey.DATA;
import static com.micoservices.rating.enums.ApiKey.SUCCESS;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micoservices.rating.entity.RatingMaster;
import com.micoservices.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ratings")
public class RatingApis {

	private final RatingService ratingService;

	@PostMapping
	ResponseEntity<Map<Object, Object>> saveRatings(@RequestBody RatingMaster ratingMaster) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.save(ratingMaster));
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping
	ResponseEntity<Map<Object, Object>> getAllRatings() {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.getAll());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping
	ResponseEntity<Map<Object, Object>> updateRatings(@RequestBody RatingMaster ratingMaster) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.update(ratingMaster));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/{ratinglId}")
	ResponseEntity<Map<Object, Object>> getRatingsById(@PathVariable String ratinglId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.getById(ratinglId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("/{ratinglId}")
	ResponseEntity<Map<Object, Object>> deleteRating(@PathVariable String ratinglId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.delete(ratinglId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	ResponseEntity<Map<Object, Object>> getByHotelId(@PathVariable String hotelId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.getRatingsByHotel(hotelId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	ResponseEntity<Map<Object, Object>> getRatingsByUserId(@PathVariable String userId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, ratingService.getRatingsByUser(userId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

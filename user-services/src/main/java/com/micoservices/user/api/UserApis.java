package com.micoservices.user.api;

import static com.micoservices.user.constants.ApiUrls.BASE_USER;
import static com.micoservices.user.constants.ApiUrls.DY_USER_ID;
import static com.micoservices.user.enums.ApiKey.DATA;
import static com.micoservices.user.enums.ApiKey.SUCCESS;

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

import com.micoservices.user.dto.User;
import com.micoservices.user.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_USER)
@Slf4j
public class UserApis {

	private final UserServices userServices;

	@PostMapping
	public ResponseEntity<Map<Object, Object>> createUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.save(user));
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping(DY_USER_ID)
	// @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod =
	// "handleCircuitBreaks")
	@Retry(name = "serviceRetrier", fallbackMethod = "handleCircuitBreaks")
	public ResponseEntity<Map<Object, Object>> getUserById(@PathVariable String userId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.getById(userId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// Method to handle circuit breaks
	public ResponseEntity<Map<Object, Object>> handleCircuitBreaks(Exception ex) {
		Map<Object, Object> map = new HashMap<>();
		log.info("failed to get data for user ,{}", ex.getMessage());
		log.info("Retrying to get response...");
		map.put(SUCCESS, false);
		map.put(DATA, "Service is temporarily down, Please try after some time.");
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "handleCircuitBreaks")
	public ResponseEntity<Map<Object, Object>> getAllUsers() {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.getAll());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Map<Object, Object>> updateUser(@RequestBody User user) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.update(user));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping(DY_USER_ID)
	public ResponseEntity<Map<Object, Object>> deleteUser(@PathVariable String userId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, userServices.delete(userId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

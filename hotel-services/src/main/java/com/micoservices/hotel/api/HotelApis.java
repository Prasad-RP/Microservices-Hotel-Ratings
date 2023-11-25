package com.micoservices.hotel.api;

import static com.micoservices.hotel.enums.ApiKey.DATA;
import static com.micoservices.hotel.enums.ApiKey.SUCCESS;

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

import com.micoservices.hotel.dto.Hotel;
import com.micoservices.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotels")
public class HotelApis {

	private final HotelService hotelService;

	@PostMapping
	public ResponseEntity<Map<Object, Object>> createHotel(@RequestBody Hotel hotel) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, hotelService.save(hotel));
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Map<Object, Object>> getAllHotels() {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, hotelService.getAll());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Map<Object, Object>> updateHotel(@RequestBody Hotel hotel) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, hotelService.update(hotel));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Map<Object, Object>> getHotelById(@PathVariable String hotelId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, hotelService.getById(hotelId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Map<Object, Object>> deleteHotel(@PathVariable String hotelId) {
		Map<Object, Object> map = new HashMap<>();
		map.put(SUCCESS, true);
		map.put(DATA, hotelService.delete(hotelId));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

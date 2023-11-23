package com.micoservices.hotel.service;

import java.util.List;
import java.util.Optional;

import com.micoservices.hotel.dto.Hotel;


public interface HotelService {

	Optional<Hotel> save(Hotel hotel);

	Optional<Hotel> update(Hotel hotel);

	Optional<Hotel> getById(String hotelId);

	List<Hotel> getAll();

	Boolean delete(String hotelId);

	Boolean existbyId(String hotelId);

}

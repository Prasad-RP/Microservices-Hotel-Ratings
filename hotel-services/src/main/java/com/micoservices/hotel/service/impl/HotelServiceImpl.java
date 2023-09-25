package com.micoservices.hotel.service.impl;

import static com.micoservices.hotel.dto.mapper.HotelMapper.TO_HOTEL;
import static com.micoservices.hotel.dto.mapper.HotelMapper.TO_HOTELS;
import static com.micoservices.hotel.dto.mapper.HotelMapper.TO_HOTEL_MASTER;
import static com.micoservices.hotel.utils.StringUtils.generateRandomHotelName;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.micoservices.hotel.dto.Hotel;
import com.micoservices.hotel.entity.HotelMaster;
import com.micoservices.hotel.exception.ResourceNotFoundException;
import com.micoservices.hotel.repository.HotelRepository;
import com.micoservices.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepository;

	@Override
	public Optional<Hotel> save(Hotel hotel) {
		Optional<HotelMaster> master = TO_HOTEL_MASTER.apply(hotel);
		// generating random and unique hotel ID
		master.get().setHotelId(generateRandomHotelName());
		return TO_HOTEL.apply(hotelRepository.save(master.get()));
	}

	@Override
	public Optional<Hotel> update(Hotel hotel) {
		existbyId(hotel.getHotelId());
		Optional<HotelMaster> master = TO_HOTEL_MASTER.apply(hotel);
		return TO_HOTEL.apply(hotelRepository.save(master.get()));
	}

	@Override
	public Optional<Hotel> getById(String hotelId) {
		return TO_HOTEL.apply(hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel", "Hotel ID", hotelId)));
	}

	@Override
	public List<Hotel> getAll() {
		return TO_HOTELS.apply(hotelRepository.findAll());
	}

	@Override
	public Boolean delete(String hotelId) {
		existbyId(hotelId);
		hotelRepository.deleteById(hotelId);
		return true;
	}

	@Override
	public Boolean existbyId(String hotelId) {
		if (hotelRepository.existsById(hotelId))
			return true;
		else
			throw new ResourceNotFoundException("Hotel", "Hotel ID", hotelId);
	}

}

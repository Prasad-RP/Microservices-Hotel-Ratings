package com.micoservices.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micoservices.hotel.entity.HotelMaster;

public interface HotelRepository extends JpaRepository<HotelMaster, String> {

}

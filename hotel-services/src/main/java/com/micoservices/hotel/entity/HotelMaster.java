package com.micoservices.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel_master")
public class HotelMaster {

	@Id
	@Column(name="hotel_id")
	private String hotelId;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="hotel_address")
	private String hotelAddress;
}

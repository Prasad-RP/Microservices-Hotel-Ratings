package com.micoservices.hotel.dto.mapper;

import static com.micoservices.hotel.utils.CollectionUtil.newList;
import static com.micoservices.hotel.utils.FunctionUtil.evalMapper;
import static com.micoservices.hotel.utils.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.micoservices.hotel.dto.Hotel;
import com.micoservices.hotel.entity.HotelMaster;

public class HotelMapper {
	
	private HotelMapper() {
		
	}

	public static final Function<Hotel, Optional<HotelMaster>> TO_HOTEL_MASTER = e -> evalMapper(e, HotelMaster.class);

	public static final Function<HotelMaster, Optional<Hotel>> TO_HOTEL = e -> evalMapper(e, Hotel.class);

	public static final Function<Collection<Hotel>, List<HotelMaster>> TO_HOTEL_MASTERS = e -> newList(
			evalMapperCollection(e, HotelMaster.class));

	public static final Function<Collection<HotelMaster>, List<Hotel>> TO_HOTELS = e -> newList(
			evalMapperCollection(e, Hotel.class));
}

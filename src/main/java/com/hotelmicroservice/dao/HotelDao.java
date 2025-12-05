package com.hotelmicroservice.dao;

import org.springframework.data.domain.Page;

import com.hotelmicroservice.entity.Hotel;

public interface HotelDao {

	// save Data
	Hotel saveHData(Hotel hotel);

	// get AllData
	Page<Hotel> getHAllData(int pageSize, int pageNumber);

	// get Data using Uuid
	Hotel getDataUsingUuid(String hotelUuid);
	
	//delete Data using Hotel
	void deleteHotelData(Hotel hotel);
}

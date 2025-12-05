package com.hotelmicroservice.service;

import com.hotelmicroservice.dto.HotelDto;
import com.hotelmicroservice.model.HotelModel;
import com.hotelmicroservice.model.HotelResponse;

public interface HotelService {

	// save Data
	HotelModel saveHData(HotelDto hotelDto);

	// get All Data
	HotelResponse getHAllData(int pageSize, int pageNumber);

	// get Data using uuid
	HotelModel getUsingUuid(String hotelUuid);

	//update Hotel Info
	HotelModel updateHotelInfo(String hotelUuid, HotelDto hotelDto);

	//delete Data using uuid
	void deleteHotelUsingUuid(String hotelUuid);
	
	
	
}

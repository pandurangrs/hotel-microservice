package com.hotelmicroservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hotelmicroservice.entity.Hotel;
import com.hotelmicroservice.exception.ResourceNotFoundException;
import com.hotelmicroservice.repo.HotelRepo;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel saveHData(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public Page<Hotel> getHAllData(int pageSize, int pageNumber) {
		return hotelRepo.findAll(PageRequest.of(pageNumber - 1, pageSize));
	}

	@Override
	public Hotel getDataUsingUuid(String hotelUuid) {
		return hotelRepo.findByUuid(hotelUuid)
				.orElseThrow(() -> new ResourceNotFoundException("Given Hotel Uuid Not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public void deleteHotelData(Hotel hotel) {
		hotelRepo.delete(hotel);
	}

}

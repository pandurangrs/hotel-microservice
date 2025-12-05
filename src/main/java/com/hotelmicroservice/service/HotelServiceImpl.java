package com.hotelmicroservice.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.hotelmicroservice.dao.HotelDao;
import com.hotelmicroservice.dto.HotelDto;
import com.hotelmicroservice.entity.Hotel;
import com.hotelmicroservice.mapper.Mapper;
import com.hotelmicroservice.model.HotelModel;
import com.hotelmicroservice.model.HotelResponse;

@Service
public class HotelServiceImpl implements HotelService {

	Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private Mapper mapper;

	@Override
	public HotelModel saveHData(HotelDto hotelDto) {

		Hotel hotel = mapper.convertToDto(hotelDto, Hotel.class);
		hotel.setUuid(UUID.randomUUID().toString());
		return mapper.convertToDto(hotelDao.saveHData(hotel), HotelModel.class);
	}

	@Override
	public HotelResponse getHAllData(int pageSize, int pageNumber) {
		HotelResponse hotelResponse = new HotelResponse();
		Page<Hotel> pageResponse = hotelDao.getHAllData(pageSize, pageNumber);
		buildPageResponse(pageResponse, hotelResponse);

		List<Hotel> hotels = pageResponse.getContent();
		List<HotelModel> hotelModels = mapper.convertToList(hotels, HotelModel.class);
		hotelResponse.setHotelModels(hotelModels);

		return hotelResponse;
	}

	private void buildPageResponse(Page<Hotel> pageResponse, HotelResponse hotelResponse) {
		hotelResponse.setLastPage(pageResponse.isLast());
		hotelResponse.setPageNumber(pageResponse.getNumber());
		hotelResponse.setPageSize(pageResponse.getSize());
		hotelResponse.setTotalElements(pageResponse.getTotalElements());
		hotelResponse.setTotalPages(pageResponse.getTotalPages());
	}

	@Override
	public HotelModel getUsingUuid(String hotelUuid) {
		return mapper.convertToDto(hotelDao.getDataUsingUuid(hotelUuid), HotelModel.class);
	}

	@Override
	public HotelModel updateHotelInfo(String hotelUuid, HotelDto hotelDto) {
		Hotel hotel = hotelDao.getDataUsingUuid(hotelUuid);
		hotel.setName(hotelDto.getName());
		hotel.setAbout(hotelDto.getAbout());
		hotel.setLocation(hotelDto.getLocation());
		Hotel saveHData = hotelDao.saveHData(hotel);
		logger.info("hotel updated Successfully with UUID : {}", hotelUuid);
		return mapper.convertToDto(saveHData, HotelModel.class);
	}

	@Override
	public void deleteHotelUsingUuid(String hotelUuid) {
		Hotel hotel = hotelDao.getDataUsingUuid(hotelUuid);
		hotelDao.deleteHotelData(hotel);
	}

}

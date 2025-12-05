package com.hotelmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmicroservice.constant.AppConstant;
import com.hotelmicroservice.constant.UrlMapping;
import com.hotelmicroservice.dto.HotelDto;
import com.hotelmicroservice.model.HotelModel;
import com.hotelmicroservice.model.HotelResponse;
import com.hotelmicroservice.service.HotelService;

@RestController
@CrossOrigin
@RequestMapping(UrlMapping.BASE_URL)
public class HotelController {

	Logger logger=LoggerFactory.getLogger(HotelController.class);

	
	@Autowired
	private HotelService hotelService;

	@PostMapping(UrlMapping.HOTEL)
	public ResponseEntity<HotelModel> saveHData(@RequestBody HotelDto hotelDto) {
		logger.info("Saving hotel info : {}",hotelDto);
		HotelModel hotelModel = hotelService.saveHData(hotelDto);
		return new ResponseEntity<>(hotelModel, HttpStatus.CREATED);
	}

	@GetMapping(UrlMapping.HOTEL)
	public ResponseEntity<HotelResponse> getAllData(
			@RequestParam(defaultValue = AppConstant.PAZE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue=AppConstant.PANE_NUMBER,required = false) int pageNumber) {
		logger.info("getting hotel info using pagination");

		HotelResponse hotelResponse = hotelService.getHAllData(pageSize,pageNumber);
		return new ResponseEntity<>(hotelResponse, HttpStatus.OK);
	}

	@GetMapping(UrlMapping.HOTEL_UUID)
	public ResponseEntity<HotelModel> getHotelInfoUsingUuid(@PathVariable String hotelUuid) {
		logger.info("getting hotel info using uuid");
		HotelModel hotelModel = hotelService.getUsingUuid(hotelUuid);
		return new ResponseEntity<>(hotelModel, HttpStatus.OK);
	}
	
	@PutMapping(UrlMapping.HOTEL_UUID)
	public ResponseEntity<HotelModel> updateHotelInfo(@PathVariable String hotelUuid,@RequestBody HotelDto hotelDto) {
		logger.info("updating hotel info");
		HotelModel hotelModel = hotelService.updateHotelInfo(hotelUuid,hotelDto);
		return new ResponseEntity<>(hotelModel, HttpStatus.OK);
	}
	
	@DeleteMapping(UrlMapping.HOTEL_UUID)
	public ResponseEntity<String> deleteHotelUsingUuid(@PathVariable String hotelUuid) {
		logger.info("deleting hotel info with UUID : {}",hotelUuid);
		hotelService.deleteHotelUsingUuid(hotelUuid);
		return new ResponseEntity<>("Hotel Info deleted Successfully.", HttpStatus.OK);
	}
	
	
}

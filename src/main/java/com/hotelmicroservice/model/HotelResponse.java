package com.hotelmicroservice.model;

import java.util.List;

import com.hotelmicroservice.payload.PaginationResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponse extends PaginationResponse{
	private List<HotelModel> hotelModels;
}

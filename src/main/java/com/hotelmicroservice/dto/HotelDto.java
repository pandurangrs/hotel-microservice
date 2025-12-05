package com.hotelmicroservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {
	private String uuid;

	private String name;

	private String about;

	private String location;
}

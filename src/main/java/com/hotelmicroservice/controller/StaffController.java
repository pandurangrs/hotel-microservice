package com.hotelmicroservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmicroservice.constant.UrlMapping;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class StaffController {

	@GetMapping("/staff")
	public ResponseEntity<List<String>> getStaff() {

		return new ResponseEntity<>(Arrays.asList("a", "Jay", "Hari"), HttpStatus.OK);
	}

}

package com.hotelmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelmicroservice.payload.ApiResponse;

@RestControllerAdvice
public class GloqbleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex) {

		ApiResponse res = new ApiResponse();
		res.setMessage(ex.getMessage());
		res.setSucccess(true);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}

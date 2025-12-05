package com.hotelmicroservice.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

	private HttpStatus status;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

}

package com.hotelmicroservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.hotelmicroservice.exception.ResourceNotFoundException;

@Component
public class Mapper {


	private ModelMapper modelMapper;

	@Autowired
	public Mapper(ModelMapper modelMapper){
		this.modelMapper=modelMapper;
	}
	

	public <T> T convertToDto(Object srcObj, Class<T> targetClass) {
		T response = null;

		try {
			response = modelMapper.map(srcObj, targetClass);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Data not convert properly to Dto", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcObj, Class<T> targetClass) {
		List<T> response = null;

		try {
			response = srcObj.stream().map(src -> modelMapper.map(src, targetClass)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Data not convert properly to List", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}

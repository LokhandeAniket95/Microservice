package com.ani.oms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ani.oms.customexception.NoSuchRecordFoundException;
import com.ani.oms.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchRecordFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFound(NoSuchRecordFoundException noSuchRecordFoundException){
		String message = noSuchRecordFoundException.getMessage();
		final var apiResponse  = ApiResponse.builder()
				.message(message)
				.success(true)
				.status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}

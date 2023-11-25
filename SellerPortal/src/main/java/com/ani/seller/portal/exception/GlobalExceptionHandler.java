package com.ani.seller.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ani.seller.portal.customexception.NoSuchRecordFoundException;
import com.ani.seller.portal.dto.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(com.ani.seller.portal.customexception.NoSuchRecordFoundException.class)
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

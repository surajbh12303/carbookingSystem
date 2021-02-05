package com.booking.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.booking.exceptions.BookingNotFound;
import com.booking.exceptions.CarNotFoundException;
import com.booking.exceptions.UserNotFoundException;

@ControllerAdvice
public class BookingExceptionHandler {

	@ExceptionHandler(value = { CarNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleApiReQuestException(CarNotFoundException e) {
		HttpStatus httpStatus = e.getHttpStatus() != null ? e.getHttpStatus() : HttpStatus.BAD_REQUEST;
		ErrorResponse errorResponse = new ErrorResponse(new Date(), httpStatus.value(), e.getMessage(), e.getPath());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}

	@ExceptionHandler(value = { BookingNotFound.class })
	public ResponseEntity<ErrorResponse> handleApiReQuestException(BookingNotFound e) {
		HttpStatus httpStatus = e.getHttpStatus() != null ? e.getHttpStatus() : HttpStatus.BAD_REQUEST;
		ErrorResponse errorResponse = new ErrorResponse(new Date(), httpStatus.value(), e.getMessage(), e.getPath());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleApiReQuestException(UserNotFoundException e) {
		HttpStatus httpStatus = e.getHttpStatus() != null ? e.getHttpStatus() : HttpStatus.BAD_REQUEST;
		ErrorResponse errorResponse = new ErrorResponse(new Date(), httpStatus.value(), e.getMessage(), e.getPath());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}

}

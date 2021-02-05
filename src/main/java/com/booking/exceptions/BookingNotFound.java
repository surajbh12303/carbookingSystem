package com.booking.exceptions;

import org.springframework.http.HttpStatus;

public class BookingNotFound extends  RuntimeException  {
	
	private static final long serialVersionUID = -163339171230743756L;
	private HttpStatus httpStatus;
	private String path;

	public BookingNotFound(String message, HttpStatus httpStatus, String path) {
		super(message);
		this.httpStatus = httpStatus;
		this.path = path;
	}

	public BookingNotFound(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public BookingNotFound(String message) {
		super(message);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}

package com.booking.exceptions;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends  RuntimeException  {
	
	
	private static final long serialVersionUID = -2012584333151004934L;
	
	
	private HttpStatus httpStatus;
	private String path;

	public CarNotFoundException(String message, HttpStatus httpStatus, String path) {
		super(message);
		this.httpStatus = httpStatus;
		this.path = path;
	}

	public CarNotFoundException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public CarNotFoundException(String message) {
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

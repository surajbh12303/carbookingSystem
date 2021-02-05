package com.booking.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends  RuntimeException  {
	
	private static final long serialVersionUID = 4280808940054729775L;
	private HttpStatus httpStatus;
	private String path;

	public UserNotFoundException(String message, HttpStatus httpStatus, String path) {
		super(message);
		this.httpStatus = httpStatus;
		this.path = path;
	}

	public UserNotFoundException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public UserNotFoundException(String message) {
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

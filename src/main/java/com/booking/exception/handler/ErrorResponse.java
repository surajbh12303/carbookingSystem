package com.booking.exception.handler;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date  timestamp;
	private Integer errorCode;
	private String errorMessage;
	private String path;
	private Throwable throwable;
	public ErrorResponse(Date  timestamp, Integer errorCode, String errorMessage, String path) {
		super();
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.path = path;
	}
	public ErrorResponse(Date  timestamp, Integer errorCode, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}


	public ErrorResponse(Date timestamp, Integer errorCode, String errorMessage, String path, Throwable throwable) {
		super();
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.path = path;
		this.throwable = throwable;
	}


	public ErrorResponse(Date  timestamp, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(Date date, int value) {

	}


	public Date  getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date  timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public Throwable getThrowable() {
		return throwable;
	}


	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}


}

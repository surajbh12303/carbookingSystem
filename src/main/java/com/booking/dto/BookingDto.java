package com.booking.dto;

import java.time.Instant;

import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.entity.User;

public class BookingDto {

	
	private Instant fromDate;

	private Instant toDate;


	private Integer carId;

	private Integer userId;

	
	public BookingDto(Instant fromDate, Instant toDate, Integer carId, Integer userId) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.carId = carId;
		this.userId = userId;
	}

	public Instant getFromDate() {
		return fromDate;
	}

	public Instant getToDate() {
		return toDate;
	}

	public Integer getCarId() {
		return carId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setFromDate(Instant fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Instant toDate) {
		this.toDate = toDate;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BookingDto [fromDate=" + fromDate + ", toDate=" + toDate + ", carId=" + carId + ", userId=" + userId
				+ "]";
	}
	
	
}

package com.booking.dto;

import java.time.Instant;


public class RegisterCar {

	private String carModel;

	private Instant insuranceTill;

	private Integer totalSeats;

	public RegisterCar(String carModel, Instant insuranceTill, Integer totalSeats) {
		super();
		this.carModel = carModel;
		this.insuranceTill = insuranceTill;
		this.totalSeats = totalSeats;
	}
	
	public RegisterCar() {
	}

	public String getCarModel() {
		return carModel;
	}

	public Instant getInsuranceTill() {
		return insuranceTill;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setInsuranceTill(Instant insuranceTill) {
		this.insuranceTill = insuranceTill;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	
}

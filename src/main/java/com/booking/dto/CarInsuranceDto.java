package com.booking.dto;

import java.time.Instant;

public class CarInsuranceDto {
	private Instant fromdate;
	private Instant toDate;
	
	

	public CarInsuranceDto(Instant fromdate, Instant toDate) {
		super();
		this.fromdate = fromdate;
		this.toDate = toDate;
	}

	public Instant getFromdate() {
		return fromdate;
	}

	public Instant getToDate() {
		return toDate;
	}

	public void setFromdate(Instant fromdate) {
		this.fromdate = fromdate;
	}

	public void setToDate(Instant toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "CarInsuranceDto [fromdate=" + fromdate + ", toDate=" + toDate + "]";
	}
	
	

}

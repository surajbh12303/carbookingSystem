package com.booking.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer carId;

	@Column(name = "model")
	private String carModel;

	@Column(name = "insurance_till")
	private Instant insuranceTill;

	@Column
	private Integer totalSeats;
	
//	@OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//            )
//	private Booking booking ;

	public Car() {
	}
	
	public Car( String carModel, Instant insuranceTill, Integer totalSeats) {
		super();
		this.carModel = carModel;
		this.insuranceTill = insuranceTill;
		this.totalSeats = totalSeats;
	}
	

	public Car(Integer carId, String carModel, Instant insuranceTill, Integer totalSeats) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.insuranceTill = insuranceTill;
		this.totalSeats = totalSeats;
	}

   



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + ((insuranceTill == null) ? 0 : insuranceTill.hashCode());
		result = prime * result + ((totalSeats == null) ? 0 : totalSeats.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
			return false;
		if (insuranceTill == null) {
			if (other.insuranceTill != null)
				return false;
		} else if (!insuranceTill.equals(other.insuranceTill))
			return false;
		if (totalSeats == null) {
			if (other.totalSeats != null)
				return false;
		} else if (!totalSeats.equals(other.totalSeats))
			return false;
		return true;
	}

	public Integer getCarId() {
		return carId;
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

	public void setCarId(Integer carId) {
		this.carId = carId;
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

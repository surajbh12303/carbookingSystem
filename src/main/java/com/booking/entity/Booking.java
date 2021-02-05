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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer bookingId;

	@Column(name = "booking_from_date")
	private Instant fromDate;

	@Column(name = "booking_to_date")
	private Instant toDate;

	@ManyToOne( optional = false, cascade = { CascadeType.ALL })
	@JoinColumn(name = "car_id")
	private Car car;

	@ManyToOne(optional = false, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private User user;

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	public Booking(Integer bookingId, Instant fromDate, Instant toDate, User user) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.user = user;
		
	}
	
	public Booking(){
		
	}
	
	public Booking( Instant fromDate, Instant toDate, User user,Car car) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.user = user;
		this.car = car;
	}
	

	public Booking(Integer bookingId, Instant fromDate, Instant toDate, Car car, User user) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.car = car;
		this.user = user;
	}
	
	

	public Integer getBookingId() {
		return bookingId;
	}

	public Instant getFromDate() {
		return fromDate;
	}

	public Instant getToDate() {
		return toDate;
	}

	public Car getCar() {
		return car;
	}

	public User getUser() {
		return user;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public void setFromDate(Instant fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Instant toDate) {
		this.toDate = toDate;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", car=" + car
				+ ", user=" + user + "]";
	}
	
	

}

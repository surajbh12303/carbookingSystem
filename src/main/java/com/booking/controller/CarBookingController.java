package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.BookingDto;
import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.service.BookingService;
import com.booking.service.CarService;

@RestController
@RequestMapping("api/book")
public class CarBookingController {

	@Autowired
	private CarService carService;

	@Autowired
	private BookingService bookingService;

	@PostMapping("registercar")
	public ResponseEntity<Car> RegisterCar(@RequestBody com.booking.dto.RegisterCar car) {
		return ResponseEntity.status(HttpStatus.OK).body(this.carService.registerCar(car));
	}

	@PostMapping("carbookingdetails")
	public List<Booking> getCarBookingDetails(@RequestBody BookingDto bookingDto) {
		return this.bookingService.getCarBookingBetDates(bookingDto);
	}

}

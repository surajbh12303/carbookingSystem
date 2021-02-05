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
import com.booking.dto.CarInsuranceDto;
import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.service.BookingService;
import com.booking.service.CarService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private BookingService bookingService;
	
	

	@PostMapping("/carwithvalidInsurance")
	public ResponseEntity<List<Car>> findCarWithValidinsurance(@RequestBody CarInsuranceDto carInsuranceDto) {
		System.out.println(carInsuranceDto);
		return ResponseEntity.status(HttpStatus.OK).body(this.carService.findCarWithValidInsurance(carInsuranceDto));
	}
	
	@PostMapping("/bookcar")
	public ResponseEntity<Booking> registerBooking(@RequestBody BookingDto bookingDto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.bookingService.bookCar(bookingDto));
	}
	
	@PostMapping("/userbooking")
	public ResponseEntity<List<Booking>> getUserBookingBetweenDates(@RequestBody BookingDto bookingDto){
		return ResponseEntity.status(HttpStatus.OK).body(this.bookingService.getUserBookingBetDates(bookingDto));
	}

}

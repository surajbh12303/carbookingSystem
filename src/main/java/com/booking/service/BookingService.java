package com.booking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.booking.dto.BookingDto;
import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.entity.User;
import com.booking.exceptions.BookingNotFound;
import com.booking.exceptions.CarNotFoundException;
import com.booking.exceptions.UserNotFoundException;
import com.booking.repository.BookingRepository;
import com.booking.repository.CarRepository;
import com.booking.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	public Booking bookCar(BookingDto bookingDto) {
		Car car = this.carRepository.findById(bookingDto.getCarId())
				.orElseThrow(() -> new CarNotFoundException("Car Not Found", HttpStatus.NOT_FOUND));
		User user = this.userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User Not Found", HttpStatus.NOT_FOUND));
		Booking booking = new Booking(bookingDto.getFromDate(), bookingDto.getToDate(), user, car);
		return this.bookingRepository.save(booking);
	}

	public List<Booking> getUserBookingBetDates(BookingDto bookingDto) {
		User user = this.userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User Not Found", HttpStatus.NOT_FOUND));

		List<Booking> bookingList = this.bookingRepository.findByUser(user)
				.orElseThrow(() -> new BookingNotFound("Booking list not exit fond for user ", HttpStatus.NOT_FOUND));

		bookingList = bookingList.stream().filter(book -> book.getToDate().isBefore(bookingDto.getToDate())
				&& book.getFromDate().isAfter(bookingDto.getFromDate())).collect(Collectors.toList());

//		return bookingList;
	return	this.bookingRepository.findBookingByDateAndByUser(user,bookingDto.getFromDate(),bookingDto.getToDate());

	}

	public List<Booking> getCarBookingBetDates(BookingDto bookingDto) {
		Car car = this.carRepository.findById(bookingDto.getCarId())
				.orElseThrow(() -> new CarNotFoundException("Car Not Found", HttpStatus.NOT_FOUND));
		List<Booking> bookingList = this.bookingRepository.findByCar(car)
				.orElseThrow(() -> new BookingNotFound("Booking list not exit for car ", HttpStatus.NOT_FOUND));

		bookingList = bookingList.stream().filter(book -> book.getToDate().isBefore(bookingDto.getToDate())
				&& book.getFromDate().isAfter(bookingDto.getFromDate())).collect(Collectors.toList());

		return bookingList;

	}

}

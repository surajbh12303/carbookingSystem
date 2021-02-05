package com.booking.test;


import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.Calendar;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.booking.dto.BookingDto;
import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.entity.User;
import com.booking.repository.BookingRepository;
import com.booking.repository.CarRepository;
import com.booking.repository.UserRepository;
import com.booking.service.BookingService;
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class BookServiceTest {
	
	@MockBean
	private CarRepository carRepository;

	
	@MockBean
	private UserRepository userRepository;
	

	@MockBean
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private BookingService bookingService;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	public Instant toInstant(int yyyy, int MM , int dd) {
		Calendar cal = Calendar.getInstance();
        cal.set(yyyy, MM, dd);
		return cal.toInstant();
	}
	
	@Test
	public void testbookCar() {
		Instant fromDate = toInstant(2021, 2, 10);
		Instant toDate = toInstant(2021, 2, 10);
		Optional<Car> car =Optional.of(new Car(1, "SWIFT", toInstant(2025, 1, 15), 2));
		Mockito.when(carRepository.findById(1)).thenReturn(car);
		Optional<User> user = Optional.of( new User(2, "suraj1", "suraj1@gmail.com"));
		Mockito.when(userRepository.findById(1)).thenReturn(user);
		Booking bookedCar=new Booking(fromDate, toDate, user.get(),car.get());
		Mockito.when(bookingRepository.save(new Booking(1,fromDate, toDate, car.get(), user.get()))).thenReturn(new Booking(1,fromDate,toDate, car.get(), user.get()));
		assertTrue(this.bookingService.bookCar(new BookingDto(toInstant(2021, 2, 10),toInstant(2021, 2, 15),1,1)).equals(bookedCar));
         

	}

}

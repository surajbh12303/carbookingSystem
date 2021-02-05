package com.booking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.entity.User;
import com.booking.repository.BookingRepository;
import com.booking.repository.CarRepository;
import com.booking.repository.UserRepository;
import com.booking.service.BookingService;

public class BookingRepositoryTest {

	@InjectMocks
	BookingService bookingService;
	
	@Mock
	UserRepository userRepository;

	@Mock
	CarRepository carRepository;
	
	@Mock
	BookingRepository bookigRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	public List<Booking> getBookingList(){
		User user1 = new User(1, "suraj1", "suraj1@gmail.com");
		User user2 = new User(1, "suraj2", "suraj2@gmail.com");
		User user3 = new User(1, "suraj3", "suraj3@gmail.com");
		User user4 = new User(1, "suraj4", "suraj4@gmail.com");
		Car car1 = new Car(1, "SWIFT", toInstant(2025, 1, 15), 2);
		Car car2 = new Car(1, "Audi", toInstant(2022, 1, 15), 4);
		Car car3 = new Car(1, "Maruti", toInstant(2024, 1, 15), 6);
		
		List<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(new Booking(1,toInstant(2021, 2, 2),toInstant(2021, 2, 8),car1,user1));
        assertEquals(2,2);
		
		return bookingList;
	}
	
	
	public Instant toInstant(int yyyy, int MM , int dd) {
		Calendar cal = Calendar.getInstance();
        cal.set(yyyy, MM, dd);
		return cal.toInstant();
	}
	
	@Test
	public void testGetAllComplaints(){
		List<Booking> bookingList = getBookingList();
		Car car1 = new Car(1, "SWIFT", toInstant(2025, 1, 15), 2);
		Optional<List<Booking>> list = null;
		Mockito.when(this.bookigRepository.findByCar(car1)).thenReturn(list);
		System.out.println(list);
		assertEquals(1,list.get().size());
	}
}

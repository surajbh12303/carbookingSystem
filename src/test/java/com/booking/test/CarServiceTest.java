package com.booking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.booking.dto.CarInsuranceDto;
import com.booking.entity.Car;
import com.booking.repository.CarRepository;
import com.booking.service.BookingService;
import com.booking.service.CarService;

public class CarServiceTest {

	@Mock
	private CarRepository carRepository;
	
	@InjectMocks
	private CarService carService;

	private Instant getInstant(int year,int month,int day) {
		 Calendar cal = Calendar.getInstance();
		   cal.set(year, year, day);
		   return cal.toInstant();
	}
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("find car with valid insurance")
	public void testCarWithValidInsurance() {
	  
	//	CarService carService = new CarService();
		List<Car> carlist = new ArrayList<>();
		carlist.add(new Car(1, "swift1", getInstant(2021, 2, 3), 4));
		carlist.add(new Car(2, "swift2", getInstant(2024, 2, 3), 4));

		Mockito.when(this.carRepository.findByInsuranceTillGreaterThan(getInstant(2022, 2, 3))).thenReturn(carlist);
		CarInsuranceDto carInsuranceDto = new CarInsuranceDto(getInstant(2018, 2, 3), getInstant(2022, 2, 3));
		 List<Car> carRes = carService.findCarWithValidInsurance(carInsuranceDto);
	   System.out.println(carRes);
		 assertEquals(carRes.size(), 0);
	}

}

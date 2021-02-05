package com.booking;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.booking.entity.Car;
import com.booking.entity.User;
import com.booking.repository.BookingRepository;
import com.booking.repository.CarRepository;
import com.booking.repository.UserRepository;
import com.sun.el.parser.ParseException;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CarBookingSystemApplication implements CommandLineRunner {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarBookingSystemApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.booking.controller")) // selecting handler
				.paths(PathSelectors.any()) // selecting request mapping
				.build();
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	public Instant toInstant(int yyyy, int MM , int dd) {
		Calendar cal = Calendar.getInstance();
        cal.set(yyyy, MM, dd);
		return cal.toInstant();
	}

}

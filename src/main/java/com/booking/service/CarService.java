package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.booking.dto.CarInsuranceDto;
import com.booking.dto.RegisterCar;
import com.booking.entity.Car;
import com.booking.exceptions.CarNotFoundException;
import com.booking.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	
	public Car registerCar(RegisterCar car) {
	return	this.carRepository.save(new Car(car.getCarModel(),car.getInsuranceTill(), car.getTotalSeats()));		
	}
	
	public List<Car> findCarWithValidInsurance(CarInsuranceDto carInsuranceDto) {
		return this.carRepository.findByInsuranceTillGreaterThan(carInsuranceDto.getToDate());
	 // return carRepository.findAll();
	}
}

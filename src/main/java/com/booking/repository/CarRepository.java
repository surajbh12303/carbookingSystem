package com.booking.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
  
	
	List<Car> findByInsuranceTillGreaterThan(Instant insuranceTill);
	
	

	
	
}

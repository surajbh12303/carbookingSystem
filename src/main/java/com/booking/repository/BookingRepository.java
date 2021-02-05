package com.booking.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.entity.Booking;
import com.booking.entity.Car;
import com.booking.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	List<Booking> findByFromDate(Instant fromDate);
	
	Optional<List<Booking>> findByUser(User user);
	
	Optional<List<Booking>> findByCar(Car car);
	
//	 @Query("SELECT b FROM Booking b WHERE b.user =:user and b.fromDate >=:fromDate and b.toDate <=:toDate")
//     List<Booking> findUserBooking(@Param("user") User user,@Param("fromDate")Instant fromDate,@Param("toDate")Instant toDate);
	 
	 @Query("SELECT b FROM Booking b WHERE b.user =:car and b.fromDate >=:fromDate and b.toDate <=:toDate")
     List<Booking> findCarBooking(@Param("car") Car car,@Param("fromDate")Instant fromDate,@Param("toDate")Instant toDate);

	 @Query("SELECT b FROM Booking b WHERE b.user = ?1 and b.fromDate >= ?2 and b.toDate <= ?3")
	List<Booking> findBookingByDateAndByUser(User user,Instant fromdDate,Instant toDate );

	 

}




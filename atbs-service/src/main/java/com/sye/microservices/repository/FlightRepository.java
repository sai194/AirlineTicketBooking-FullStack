package com.sye.microservices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sye.microservices.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {
	
	public List<Flight> findByFromCityAndToCity(String fromCity, String toCity);
	public List<Flight> findByFromCityAndToCityAndDepartureDateGreaterThanEqualAndHrsGreaterThanEqualAndMinsGreaterThanEqualAndPassengerCountGreaterThanEqualAndSeatingClass
	(String fromCity,String toCity ,
			Date departureDate, Long hrs,
			Long mins,Long passengerCount,
			String seatingClass);

}

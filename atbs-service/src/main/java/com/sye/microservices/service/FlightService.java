package com.sye.microservices.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sye.microservices.domain.Flight;
import com.sye.microservices.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> findFlights(){
		return flightRepository.findAll();
	}
	
	public List<Flight> findFlightsByQuery(String fromCity,String toCity){
		return flightRepository.findByFromCityAndToCity(fromCity, toCity);
	}
	
	public List<Flight> findFlightsByQuery( String fromCity,String toCity ,
			String departureDate, Long hrs,
			Long mins,Long passenger,
			String seating){
		return flightRepository
				.findByFromCityAndToCityAndDepartureDateGreaterThanEqualAndHrsGreaterThanEqualAndMinsGreaterThanEqualAndPassengerCountGreaterThanEqualAndSeatingClass
				(fromCity, toCity,new Date(),hrs,mins,passenger,seating);
	}
}

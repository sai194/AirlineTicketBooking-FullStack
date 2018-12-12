package com.sye.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sye.microservices.domain.Flight;
import com.sye.microservices.service.FlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	@GetMapping("/flights/{fromCity}/{toCity}/{departureDate}/{hrs}/{mins}/{passenger}/{seating}")
	public List<Flight> getAllFlights(@PathVariable String fromCity,@PathVariable String toCity ,
			@PathVariable String departureDate,@PathVariable Long hrs,
			@PathVariable Long mins,@PathVariable Long passenger,
			@PathVariable String seating
			) {
		return flightService.findFlightsByQuery(fromCity,toCity,departureDate,hrs,mins,passenger,seating);
	}

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.findFlights();
	}
}

package com.sye.microservices;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sye.microservices.domain.Flight;
import com.sye.microservices.domain.User;
import com.sye.microservices.repository.FlightRepository;
import com.sye.microservices.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtbsServiceApplicationTests {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlightRepository flightRepository;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAdmin() {

		User adminUser = userService.findUserByUserName("admin@gmail.com");
		Assert.assertEquals("admin@gmail.com", adminUser.getUserName());
	}
	
	@Test
	public void testUser() {

		User user = userService.findUserByUserName("user@gmail.com");
		Assert.assertEquals("user@gmail.com", user.getUserName());
	}

	@Test
	public void testFlights() {
		List<Flight> flights = flightRepository.findAll();
		Assert.assertEquals(5, flights.size());
	}

}

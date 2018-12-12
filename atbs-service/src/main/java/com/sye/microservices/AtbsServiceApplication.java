package com.sye.microservices;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sye.microservices.domain.Flight;
import com.sye.microservices.domain.Role;
import com.sye.microservices.domain.Ticket;
import com.sye.microservices.domain.User;
import com.sye.microservices.repository.FlightRepository;
import com.sye.microservices.repository.RoleRepository;
import com.sye.microservices.repository.TicketRepository;
import com.sye.microservices.service.UserService;

@SpringBootApplication
public class AtbsServiceApplication  implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private RoleRepository roleRepository; 
	public static void main(String[] args) {
		SpringApplication.run(AtbsServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role adminRole= new Role("ADMIN");
		Role userRole= new Role("USER");
		roleRepository.save(adminRole);
		roleRepository.save(userRole);
		
		User admin = userService.findUserByUserName("admin");
		if(admin ==null) {
			admin = new User("admin@gmail.com","welcome1","admin","system");
			userService.saveUserWithAdmin(admin);
			System.out.println("Admin created!!!");
		}else {
			System.out.println("Admin exists!!!");
		}
		
		User user = userService.findUserByUserName("user");
		if(user ==null) {
			user = new User("user@gmail.com","welcome1","user","system");
			userService.saveUser(user);
			System.out.println("Default user created!!!");
		}else {
			System.out.println("Default user exists!!!");
		}
		
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		
		Flight f1 = new Flight("American Airlines", "NY", "LV", date, c.getTime(),
			30L, 3000D,"Business",7L,30L,21L,30L);
		flightRepository.save(f1);
		Flight f1_1 = new Flight("Spirit Airlines", "NY", "LV", date, c.getTime(),
				30L, 3000D,"Business",7L,30L,21L,30L);
			flightRepository.save(f1_1);
		
		Flight f2 = new Flight("South West Airlines", "SFO", "LV", date, c.getTime(),
				30L, 3000D,"Economy",7L,30L,21L,30L);
		flightRepository.save(f2);
		
		Flight f3 = new Flight("Delta", "CLT", "LA", date, c.getTime(),
				30L, 3000D,"Business",10L,30L,21L,30L);
		flightRepository.save(f3);
		
		Flight f4 = new Flight("Frontier", "NY", "LV", date, c.getTime(),
				30L, 3000D,"Economy",20L,0L,21L,30L);
		flightRepository.save(f4);
		
		/*Ticket t1 = new Ticket("Delta", "NY", "LV", date, c.getTime(),
				30L,"Business", 3000D,"admin@gmail.com",1,7L,30L,21L,30L,-1L);
		ticketRepository.save(t1);*/
		
	}
}

package com.sye.microservices.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sye.microservices.domain.Ticket;
import com.sye.microservices.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/tickets/{userName}")
	public List<Ticket> getAllTicketsForUser(@PathVariable String userName){
		return ticketService.findTicketsByUserNameAndActive(userName);
	}
	
	@PutMapping("/tickets/{username}")
	public ResponseEntity<Ticket> updateTicket(
			@PathVariable String username, @RequestBody String ids){
		/*if (ids.lastIndexOf(",") != -1)
            ids = ids.substring(0, ids.lastIndexOf(","));*/
		 ids = ids.substring(1, ids.length());
		System.out.println(ids);
		Ticket ticket =null;
		List<String> idList = Arrays.asList(ids.split(","));
		for(String id : idList) {
			ticket = ticketService.saveTicket(id);
		}
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@PostMapping("/tickets/{userName}/{passengerCount}")
	public ResponseEntity<Void> updatePolicy(@PathVariable String userName,
			@PathVariable Long passengerCount, @RequestBody String ids){
		
		
		Ticket createdTicket = null;
        //if (ids.lastIndexOf(",") != -1)
            ids = ids.substring(1, ids.length());
        
        System.out.println(ids);
		List<String> idList =  Arrays.asList(ids.split(","));
		for(String id : idList) {
			createdTicket = ticketService.saveTicketByFlightId(new Long(id),passengerCount,userName);
		}
		
		 
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTicket.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	

}

package com.sye.microservices.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sye.microservices.domain.Flight;
import com.sye.microservices.domain.Ticket;
import com.sye.microservices.repository.FlightRepository;
import com.sye.microservices.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	FlightRepository flightRepository;

	public List<Ticket> findTicketsByUserName(String userName) {
		return ticketRepository.findByUserName(userName);
	}
	public List<Ticket> findTicketsByUserNameAndActive(String userName) {
		return ticketRepository.findByUserNameAndActive(userName,1);
	}

	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		if (ticket.getActive() == 1) {
			ticket.setActive(-1);
		} else {
			ticket.setActive(1);
		}
		return ticketRepository.save(ticket);
	}

	public Ticket saveTicket(String id) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(new Long(id)).orElse(null);
		if (ticket != null) {
			if (ticket.getActive() == 1) {
				ticket.setActive(-1);
				Flight flight = flightRepository.findById(ticket.getFlightId()).orElse(null);
				if(flight!=null) {
					flight.setPassengerCount(flight.getPassengerCount()+ticket.getPassengerCount());
					 flightRepository.save(flight);
				}
			} else {
				ticket.setActive(1);
			}
			return ticketRepository.save(ticket);
		}
		return ticket;

	}

	public Ticket saveTicketByFlightId(Long flightId, Long passengerCount,String userName) {
		// TODO Auto-generated method stub
		Ticket ticket =null;
		Flight flight = flightRepository.findById(flightId).orElse(null);
		if(flight!=null) {
		 ticket = new Ticket(flight.getAirlines(), flight.getFromCity(), flight.getToCity(), flight.getDepartureDate(), flight.getArrivalDate(),
				passengerCount, flight.getSeatingClass(), flight.getPrice(),userName,1,flight.getHrs(),flight.getMins(),flight.getArrivalHrs(),
				flight.getArrivalMins(),flight.getId());
		 flight.setPassengerCount(flight.getPassengerCount()-passengerCount);
		 flightRepository.save(flight);
		 return ticketRepository.save(ticket);
		
		}
		
		return ticket;
	}

}

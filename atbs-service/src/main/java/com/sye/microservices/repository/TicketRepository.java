package com.sye.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sye.microservices.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

	public List<Ticket> findByUserName(String userName);

	public List<Ticket> findByUserNameAndActive(String userName, int i);

}

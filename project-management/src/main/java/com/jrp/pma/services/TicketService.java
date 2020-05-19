package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.dto.TicketEmployee;
import com.jrp.pma.entities.Ticket;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepo;
	
	public Ticket save(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public List<Ticket> getAll(){
		return ticketRepo.findAll();
	}
	
	public List<TicketEmployee> ticketsEmployee(){
		return ticketRepo.ticketsEmployee();
	} 
}

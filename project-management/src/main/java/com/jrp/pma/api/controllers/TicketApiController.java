package com.jrp.pma.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.entities.Ticket;

@RestController
@RequestMapping("/app-api/tickets")
public class TicketApiController {
	@Autowired
	TicketRepository ticketRepo;
	
	
	@GetMapping
	public Iterable<Ticket> getTickets(){
		return ticketRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Ticket getTicketById(@PathVariable("id") Long id) {
		return ticketRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket create(@RequestBody @Valid Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Ticket update(@RequestBody @Valid Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json")
	public Ticket partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Ticket patchTicket) {
		Ticket tic = ticketRepo.findById(id).get();
		
		if(patchTicket.getTitle() != null) {
			tic.setTitle(patchTicket.getTitle());
		}
		if(patchTicket.getDescription() != null) {
			tic.setDescription(patchTicket.getDescription());
		}
		if(patchTicket.getDate() != null) {
			tic.setDate(patchTicket.getDate());
		}
		if(patchTicket.getPriority() != null) {
			tic.setPriority(patchTicket.getPriority());
		}
		if(patchTicket.getStatus() != null) {
			tic.setStatus(patchTicket.getStatus());
		}
		if(patchTicket.getType() != null) {
			tic.setType(patchTicket.getType());
		}
		
		return ticketRepo.save(tic);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		
		try {
		ticketRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
	
}
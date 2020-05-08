package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.dto.TicketEmployee;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.entities.Ticket;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayTicketForm(Model model) {
		
		Ticket aTicket = new Ticket();
		model.addAttribute("ticket", aTicket);
		
		List<Ticket> tickets = ticketRepo.findAll();
		model.addAttribute("ticketsList", tickets);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<TicketEmployee> ticketAndEmployee = ticketRepo.ticketsEmployee();
		model.addAttribute("ticketsListAndEmployee", ticketAndEmployee);
		
		return "tickets/new-ticket";
	}
	
	@PostMapping("/save")
	public String createTicket(Ticket ticket,@RequestParam List<Long> theEmployee,@RequestParam List<Long> theProject, Model model) {
		//this will handle saving to the DB...
		ticketRepo.save(ticket);
		
		Iterable <Employee> chosenEmployee = empRepo.findAllById(theEmployee);
		
		for(Employee emp : chosenEmployee) {
			emp.setTickets(ticket);
			empRepo.save(emp);
		}
		Iterable <Project> chosenProject = proRepo.findAllById(theProject);
		
		for(Project proj : chosenProject) {
			proj.setTickets(ticket);
			proRepo.save(proj);
		}
		
		
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/tickets/new";
		
		
	}
}
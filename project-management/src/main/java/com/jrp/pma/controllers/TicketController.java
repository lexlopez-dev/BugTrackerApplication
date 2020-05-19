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
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import com.jrp.pma.services.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/new")
	public String displayTicketForm(Model model) {
		
		Ticket aTicket = new Ticket();
		model.addAttribute("ticket", aTicket);
		
		List<Ticket> tickets = ticketService.getAll();
		model.addAttribute("ticketsList", tickets);
		
		List<Employee> employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		List<TicketEmployee> ticketAndEmployee = ticketService.ticketsEmployee();
		model.addAttribute("ticketsListAndEmployee", ticketAndEmployee);
		
		return "tickets/new-ticket";
	}
	
	@PostMapping("/save")
	public String createTicket(Ticket ticket,@RequestParam List<Long> theEmployee,@RequestParam List<Long> theProject, Model model) {
		//this will handle saving to the DB...
		ticketService.save(ticket);
		
		Iterable <Employee> chosenEmployee = empService.getAllById(theEmployee);
		
		for(Employee emp : chosenEmployee) {
			emp.setTickets(ticket);
			empService.save(emp);
		}
		Iterable <Project> chosenProject = proService.getAllById(theProject);
		
		for(Project proj : chosenProject) {
			proj.setTickets(ticket);
			proService.save(proj);
		}
		
		
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/tickets/new";
		
		
	}
}
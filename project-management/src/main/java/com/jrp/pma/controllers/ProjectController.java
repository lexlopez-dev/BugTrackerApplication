package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.entities.Ticket;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import com.jrp.pma.services.TicketService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		List<Employee> employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		
		List<Ticket> tickets = ticketService.getAll();
		model.addAttribute("allTickets", tickets);
		
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/new-project";
		
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this will handle saving to the DB...
		proService.save(project);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";	
	}
	
	
	
}

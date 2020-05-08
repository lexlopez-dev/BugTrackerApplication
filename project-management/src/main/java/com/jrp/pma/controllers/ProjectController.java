package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.entities.Ticket;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		
		List<Ticket> tickets = ticketRepo.findAll();
		model.addAttribute("allTickets", tickets);
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/new-project";
		
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this will handle saving to the DB...
		proRepo.save(project);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
		
		
	}
	
}

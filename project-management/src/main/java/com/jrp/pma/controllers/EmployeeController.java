package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		List<EmployeeTicket> employeesTicketCnt = empRepo.employeeTickets();
		model.addAttribute("employeesListTicketsCnt", employeesTicketCnt);
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		//this will handle saving to the DB...
		empRepo.save(employee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/new";
		
	}
}

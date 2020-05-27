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

import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		
		List<Employee> employees = empService.getAll();
		model.addAttribute("employeesList", employees);
		
		List<EmployeeTicket> employeesTicketCnt = empService.employeeTickets();
		model.addAttribute("employeesListTicketsCnt", employeesTicketCnt);
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		//this will handle saving to the DB...
		empService.save(employee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/new";
		
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {
		
		Employee theEmp = empService.findByEmployeeId(theId);
		model.addAttribute("employee", theEmp);
		
		List<Employee> employees = empService.getAll();
		model.addAttribute("employeesList", employees);
		
		List<EmployeeTicket> employeesTicketCnt = empService.employeeTickets();
		model.addAttribute("employeesListTicketsCnt", employeesTicketCnt);
		return "employees/update-employee"; 
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId, Model model) {
		Employee theEmp = empService.findByEmployeeId(theId);
		
		empService.delete(theEmp);
		
		return "redirect:/employees/new";
	}
	
}

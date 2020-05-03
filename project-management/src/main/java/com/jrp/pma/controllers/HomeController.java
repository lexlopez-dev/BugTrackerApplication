package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.dto.TicketPriority;
import com.jrp.pma.dto.TicketStatus;
import com.jrp.pma.dto.TicketType;
import com.jrp.pma.entities.Project;
import com.jrp.pma.entities.Ticket;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
//Ticket Status		
		List<TicketStatus> ticketData = ticketRepo.ticketsPerStatus();
		
		//Convert ticketData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(ticketData);
		
		model.addAttribute("ticketStatusCnt", jsonString);
		
//Ticket Priority		
		List<TicketPriority> ticketPriorityData = ticketRepo.ticketsPerPriority();
		
		//Convert ticketData object into a json structure for use in javascript
		String jsonString2 = objectMapper.writeValueAsString(ticketPriorityData);
		
		model.addAttribute("ticketPriorityCnt", jsonString2);		
		
//Ticket Type
		List<TicketType> ticketTypeData = ticketRepo.ticketsPerType();
		
		//Convert ticketData object into a json structure for use in javascript
		String jsonString3 = objectMapper.writeValueAsString(ticketTypeData);
		
		model.addAttribute("ticketTypeCnt", jsonString3);
		
		
		List<Ticket> tickets = ticketRepo.findAll();
		model.addAttribute("ticketsList", tickets);
		
		
		return "main/home";
	}
}

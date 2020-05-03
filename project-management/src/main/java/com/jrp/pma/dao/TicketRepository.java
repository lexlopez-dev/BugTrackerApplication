package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.dto.TicketEmployee;
import com.jrp.pma.dto.TicketPriority;
import com.jrp.pma.dto.TicketStatus;
import com.jrp.pma.dto.TicketType;
import com.jrp.pma.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	@Override
	public List<Ticket> findAll();
	
	@Query(nativeQuery=true, value="SELECT t.title as title,t.description, t.priority, t.status, t.type, e.first_name as firstName, e.last_name as lastName " + 
			"FROM ticket t left join employee e ON t.employee_id = e.employee_id " + 
			"GROUP BY t.title, t.description, t.priority, t.status, t.type, e.first_name, e.last_name ORDER BY 3 DESC")
	public List<TicketEmployee> ticketsEmployee();
	
	
	@Query(nativeQuery=true, value="SELECT priority as label, COUNT(*) as value " + 
			"FROM ticket " + 
			"GROUP BY priority")
	public List<TicketPriority> ticketsPerPriority ();
	
	@Query(nativeQuery=true, value="SELECT status as label, COUNT(*) as value " + 
			"FROM ticket " + 
			"GROUP BY status")
	public List<TicketStatus> ticketsPerStatus();
	
	@Query(nativeQuery=true, value="SELECT type as label, COUNT(*) as value " + 
			"FROM ticket " + 
			"GROUP BY type")
	public List<TicketType> ticketsPerType();	
	
}
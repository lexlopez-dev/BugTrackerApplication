package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.dto.TicketPriority;
import com.jrp.pma.dto.TicketStatus;
import com.jrp.pma.dto.TicketType;
import com.jrp.pma.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	@Override
	public List<Ticket> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(t.employee_id) as ticketCount " + 
			"FROM employee e left join ticket t ON t.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeTicket> employeeTickets();
	
	
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
package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jrp.pma.dto.TicketEmployee;
import com.jrp.pma.dto.TicketPriority;
import com.jrp.pma.dto.TicketStatus;
import com.jrp.pma.dto.TicketType;
import com.jrp.pma.entities.Ticket;

@RepositoryRestResource(collectionResourceRel="apitickets", path="apitickets")
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
	@Override
	public List<Ticket> findAll();
	
	@Query(nativeQuery=true, value="SELECT t.title as title,t.description, t.priority, t.status, t.type, e.first_name as firstName, e.last_name as lastName, t.ticket_id as ticketId " + 
			"FROM ticket t left join employee e ON t.employee_id = e.employee_id " + 
			"GROUP BY t.title, t.description, t.priority, t.status, t.type, e.first_name, e.last_name, t.ticket_id ORDER BY 3 DESC")
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

	public Ticket findByTicketId(long theId);	
	
}
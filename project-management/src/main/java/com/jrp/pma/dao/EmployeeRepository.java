package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.entities.Employee;


@RepositoryRestResource(collectionResourceRel="apiemployees", path="apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, e.email as email, e.role as role, e.employee_id as employeeId, COUNT(t.employee_id) as ticketCount " + 
			"FROM employee e left join ticket t ON t.employee_id = e.employee_id " + 
			"GROUP BY e.last_name, e.first_name, e.email, e.role, e.employee_id ORDER BY 3 DESC")
	public List<EmployeeTicket> employeeTickets();

	public Employee findByEmployeeId(long theId);
}

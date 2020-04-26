package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeTicket;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, e.email as email, e.role as role, COUNT(t.employee_id) as ticketCount " + 
			"FROM employee e left join ticket t ON t.employee_id = e.employee_id " + 
			"GROUP BY e.last_name ORDER BY 3 DESC")
	public List<EmployeeTicket> employeeTickets();
}

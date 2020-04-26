package com.jrp.pma.dto;

public interface EmployeeTicket {
	
	//Need to have property names begin with get
	public String getFirstName();
	public String getLastName();
	public String getEmail();
	public String getRole();
	public int getTicketCount();
}

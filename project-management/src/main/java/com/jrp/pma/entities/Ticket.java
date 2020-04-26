package com.jrp.pma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ticketId;
	private String title;
	private String description;
	private String date;
	private String priority; //low, medium high
	private String status; //open, resolved, in progress
	private String type;// bugs/errors, feature request, other request
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project theProject;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee theEmployee;
	
	public Ticket() {
		
	}
	
	public Ticket(String title, String description, String priority, String status, String type, String date) {
		super();
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.type = type;
		this.date = date;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Project getTheProject() {
		return theProject;
	}

	public void setTheProject(Project theProject) {
		this.theProject = theProject;
	}

	public Employee getTheEmployee() {
		return theEmployee;
	}

	public void setTheEmployee(Employee theEmployee) {
		this.theEmployee = theEmployee;
	}
}

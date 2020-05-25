package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
	
	@Id
	@SequenceGenerator(allocationSize=1, name = "project_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	private long projectId;
	private String name;
	
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS
	
	private String description;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", 
			joinColumns=@JoinColumn(name="project_id"),
			inverseJoinColumns= @JoinColumn(name="employee_id")
	)
	
	@JsonIgnore
	private List<Employee> employees;
	
	@JsonIgnore
	@OneToMany(mappedBy="theProject")
	private List<Ticket> tickets;
	
	
	public Project() {
		
	}

	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void setTickets(Ticket ticket) {
		// TODO Auto-generated method stub
	}

	public void setEmployees(Employee emp1) {
		// TODO Auto-generated method stub
		
	}
	
	// Methods for Editing and Deleting
	////////////////////////////////////////////////////////////
	

	
	
	
	
	
}

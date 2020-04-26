package com.jrp.pma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dao.TicketRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.entities.Ticket;

@SpringBootApplication
public class ProjectManagementApplication {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;
	
	@Autowired
	TicketRepository ticketRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner() {
//		
//		return args -> {
//			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com", "DEVELOPER");
//			Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com", "DEVELOPER");
//			Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com", "DEVELOPER");
//
//			Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com", "ADMIN");
//			Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com", "ADMIN");
//			Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com", "ADMIN");
//
//			Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com","PROJECTMANAGER");
//			Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com", "SUBMITTER");
//			Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com", "SUBMITTER");
//			
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//					+ "the final deployment of the software into production");
//			Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
//					+ "for the year and figureout who will be promoted");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
//					+ "security needs to be improved and proper security team needs to be hired for "
//					+ "implementation");
//			
//			Ticket tic1 = new Ticket("Ticket1", "The bug in the program", "LOW", "RESOLVED", "BUGSERRORS", "04/17/2020");
//			Ticket tic2 = new Ticket("Ticket2", "The bug in the program", "LOW", "OPEN", "FEATUREREQUEST", "04/15/2020");
//			Ticket tic3 = new Ticket("Ticket3", "The bug in the program", "MEDIUM", "INPROGRESS", "BUGSERRORS", "04/10/2020");
//			Ticket tic4 = new Ticket("Ticket4", "The bug in the program", "HIGH", "INPROGRESS", "BUGSERRORS", "04/16/2020");
//			Ticket tic5 = new Ticket("Ticket5", "The bug in the program", "MEDIUM", "OPEN", "FEATUREREQUEST", "04/15/2020");
//			Ticket tic6 = new Ticket("Ticket6", "The bug in the program", "LOW", "RESOLVED", "OTHERREQUEST", "04/11/2020");
//			Ticket tic7 = new Ticket("Ticket7", "The bug in the program", "MEDIUM", "RESOLVED", "BUGSERRORS", "04/12/2020");
//			Ticket tic8 = new Ticket("Ticket8", "The bug in the program", "HIGH", "INPROGRESS", "FEATUREREQUEST", "04/13/2020");
//			Ticket tic9 = new Ticket("Ticket9", "The bug in the program", "HIGH", "INPROGRESS", "OTHERREQUEST", "04/16/2020");
//			Ticket tic10 = new Ticket("Ticket10", "The bug in the program", "LOW", "INPROGRESS", "BUGSERRORS", "04/11/2020");
//			Ticket tic11 = new Ticket("Ticket11", "The bug in the program", "LOW", "OPEN", "BUGSERRORS", "04/17/2020");
//			Ticket tic12 = new Ticket("Ticket12", "The bug in the program", "MEDIUM", "RESOLVED", "FEATUREREQUEST", "04/14/2020");
//			Ticket tic13 = new Ticket("Ticket13", "The bug in the program", "HIGH", "INPROGRESS", "FEATUREREQUEST", "04/14/2020");
//			Ticket tic14 = new Ticket("Ticket14", "The bug in the program", "LOW", "OPEN", "BUGSERRORS", "04/13/2020");
//			Ticket tic15 = new Ticket("Ticket15", "The bug in the program", "HIGH", "INPROGRESS", "BUGSERRORS", "04/13/2020");
//			
//			// need to set both sides of the relationship manually
//
//			pro1.setEmployees(Arrays.asList(emp1));
//			pro1.setEmployees(Arrays.asList(emp2, emp3));
//			pro2.setEmployees(Arrays.asList(emp3));
//			pro3.setEmployees(Arrays.asList(emp2, emp1));
//			pro4.setEmployees(Arrays.asList(emp1));
//			pro4.setEmployees(Arrays.asList(emp3, emp1));
//			
//			pro1.setTickets(Arrays.asList(tic1, tic12, tic13, tic14));
//			pro2.setTickets(Arrays.asList(tic2,tic7,tic8,tic15));
//			pro3.setTickets(Arrays.asList(tic3, tic4, tic5));
//			pro4.setTickets(Arrays.asList(tic6, tic9, tic10, tic11));
//			
//			tic1.setTheProject(pro1);
//			tic2.setTheProject(pro2);
//			tic3.setTheProject(pro3);
//			tic4.setTheProject(pro3);
//			tic5.setTheProject(pro3);
//			tic6.setTheProject(pro4);
//			tic7.setTheProject(pro2);
//			tic8.setTheProject(pro2);
//			tic9.setTheProject(pro4);
//			tic10.setTheProject(pro4);
//			tic11.setTheProject(pro4);
//			tic12.setTheProject(pro1);
//			tic13.setTheProject(pro1);
//			tic14.setTheProject(pro1);
//			tic15.setTheProject(pro2);
//			
//			tic1.setTheEmployee(emp1);
//			tic2.setTheEmployee(emp1);
//			tic3.setTheEmployee(emp1);
//			tic4.setTheEmployee(emp2);
//			tic5.setTheEmployee(emp7);
//			tic6.setTheEmployee(emp7);
//			tic7.setTheEmployee(emp2);
//			tic8.setTheEmployee(emp3);
//			tic9.setTheEmployee(emp5);
//			tic10.setTheEmployee(emp5);
//			tic11.setTheEmployee(emp3);
//			tic12.setTheEmployee(emp3);
//			tic13.setTheEmployee(emp4);
//			tic14.setTheEmployee(emp4);
//			tic15.setTheEmployee(emp4);
//			
//			emp1.setTickets(Arrays.asList(tic1,tic2,tic3));
//			emp2.setTickets(Arrays.asList(tic4,tic7));
//			emp3.setTickets(Arrays.asList(tic8,tic11,tic12));
//			emp4.setTickets(Arrays.asList(tic13,tic14,tic15));
//			emp5.setTickets(Arrays.asList(tic9,tic10));
//			emp7.setTickets(Arrays.asList(tic5,tic6));
//			
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			// need to set both sides of the relationship manually
//
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//			
//			// need to set both sides of the relationship manually
//
//			emp4.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp5.setProjects(Arrays.asList(pro1));
//			emp6.setProjects(Arrays.asList(pro2, pro4));
//			
//			// save employees in database
//
//			empRepo.save(emp1);
//			empRepo.save(emp2); 
//			empRepo.save(emp3); 
//			empRepo.save(emp4);
//			empRepo.save(emp5); 
//			empRepo.save(emp6); 
//			empRepo.save(emp7); 
//			empRepo.save(emp8); 
//			empRepo.save(emp9);
//			
//			// save projects in database
//
//			projRepo.save(pro1);
//			projRepo.save(pro2); 
//			projRepo.save(pro3); 
//			projRepo.save(pro4);
//			
//			ticketRepo.save(tic1);
//			ticketRepo.save(tic2);
//			ticketRepo.save(tic3);
//			ticketRepo.save(tic4);
//			ticketRepo.save(tic5);
//			ticketRepo.save(tic6);
//			ticketRepo.save(tic7);
//			ticketRepo.save(tic8);
//			ticketRepo.save(tic9);
//			ticketRepo.save(tic10);
//			ticketRepo.save(tic11);
//			ticketRepo.save(tic12);
//			ticketRepo.save(tic13);
//			ticketRepo.save(tic14);
//			ticketRepo.save(tic15);	
//			
//		};
	

}
-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'John', 'Warton', 'warton@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Mike', 'Lanister', 'lanister@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Steve', 'Reeves', 'Reeves@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Ronald', 'Connor', 'connor@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Jim', 'Salvator', 'Sal@gmail.com', 'Admin');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Peter', 'Henley', 'henley@gmail.com', 'Admin');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Richard', 'Carson', 'carson@gmail.com', 'Submitter');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Honor', 'Miles', 'miles@gmail.com', 'ProjectManager');
insert into employee (employee_id, first_name, last_name, email, role) values (nextval('employee_seq'), 'Tony', 'Roggers', 'roggers@gmail.com', 'ProjectManager');


-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NotStarted', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New Employee Budget',  'Completed', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'InProgress', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'InProgress', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');


-- INSERT TICKETS
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 1','A bug in the system', 'Medium', 'InProgress', 'FeatureRequest', '04/18/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 2', 'A bug in the system', 'Medium', 'Open', 'BugsErrors', '04/16/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 3','A bug in the system', 'Medium', 'InProgress', 'BugsErrors', '04/17/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 4','A bug in the system', 'Low', 'InProgress', 'FeatureRequest', '04/16/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 5','A bug in the system', 'Low', 'Resolved', 'BugsErrors', '04/17/2020', (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 6','A bug in the system', 'High', 'InProgress', 'FeatureRequest', '04/18/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 7','A bug in the system', 'High', 'Open', 'BugsErrors', '04/16/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 8','A bug in the system', 'High', 'InProgress', 'OtherRequest', '04/17/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (nextval('ticket_seq'), 'Ticket 9','A bug in the system', 'High', 'Resolved', 'OtherRequest', '04/18/2020',(select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy'));


-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Reeves' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Warton' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Henley' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Henley' AND p.name = 'Improve Intranet Security');
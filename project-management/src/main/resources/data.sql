-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, last_name, email, role) values (1, 'John', 'Warton', 'warton@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (2, 'Mike', 'Lanister', 'lanister@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (3, 'Steve', 'Reeves', 'Reeves@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (4, 'Ronald', 'Connor', 'connor@gmail.com', 'Developer');
insert into employee (employee_id, first_name, last_name, email, role) values (5, 'Jim', 'Salvator', 'Sal@gmail.com', 'Admin');
insert into employee (employee_id, first_name, last_name, email, role) values (6, 'Peter', 'Henley', 'henley@gmail.com', 'Admin');
insert into employee (employee_id, first_name, last_name, email, role) values (7, 'Richard', 'Carson', 'carson@gmail.com', 'Submitter');
insert into employee (employee_id, first_name, last_name, email, role) values (8, 'Honor', 'Miles', 'miles@gmail.com', 'ProjectManager');
insert into employee (employee_id, first_name, last_name, email, role) values (9, 'Tony', 'Roggers', 'roggers@gmail.com', 'ProjectManager');


-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (1000, 'Large Production Deploy', 'NotStarted', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (1001, 'New Employee Budget',  'Completed', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (project_id, name, stage, description) values (1002, 'Office Reconstruction', 'InProgress', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (1003, 'Improve Intranet Security', 'InProgress', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');


-- INSERT TICKETS
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (111, 'Ticket 1','A bug in the system', 'Medium', 'InProgress', 'FeatureRequest', '04/18/2020', 1, 1000);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (112, 'Ticket 2', 'A bug in the system', 'Medium', 'Open', 'BugsErrors', '04/16/2020', 1, 1001);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (113, 'Ticket 3','A bug in the system', 'Medium', 'InProgress', 'BugsErrors', '04/17/2020', 2, 1000);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (114, 'Ticket 4','A bug in the system', 'Low', 'InProgress', 'FeatureRequest', '04/16/2020', 2, 1001);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (115, 'Ticket 5','A bug in the system', 'Low', 'Resolved', 'BugsErrors', '04/17/2020', 3, 1003);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (116, 'Ticket 6','A bug in the system', 'High', 'InProgress', 'FeatureRequest', '04/18/2020', 3, 1003);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (117, 'Ticket 7','A bug in the system', 'High', 'Open', 'BugsErrors', '04/16/2020', 5, 1000);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (118, 'Ticket 8','A bug in the system', 'High', 'InProgress', 'OtherRequest', '04/17/2020', 6, 1002);
insert into ticket (ticket_id, title, description, priority, status, type, date, employee_id, project_id) values (119, 'Ticket 9','A bug in the system', 'High', 'Resolved', 'OtherRequest', '04/18/2020', 6, 1002);


-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) values (1,1000);
insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);
insert into project_employee (employee_id, project_id) values (3,1000);
insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);
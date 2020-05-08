CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee (

employee_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
role VARCHAR(100) NOT NULL


);

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (

project_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
stage VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS ticket_seq;

CREATE TABLE IF NOT EXISTS ticket (

ticket_id BIGINT NOT NULL DEFAULT nextval('ticket_seq') PRIMARY KEY,
title VARCHAR(100) NOT NULL,
date VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL,
priority VARCHAR(100) NOT NULL,
status VARCHAR(100) NOT NULL,
type VARCHAR(100) NOT NULL,
project_id BIGINT REFERENCES project,
employee_id BIGINT REFERENCES employee

);


CREATE TABLE IF NOT EXISTS project_employee (

project_id BIGINT REFERENCES project, 
employee_id BIGINT REFERENCES employee

);
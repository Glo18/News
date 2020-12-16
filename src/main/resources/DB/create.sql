CREATE DATABASE department;
\c department
CREATE TABLE department(id SERIAL PRIMARY KEY,departmentName VARCHAR,departmentDescription VARCHAR,numberOfEmployees INT
);
CREATE TABLE users(id SERIAL PRIMARY KEY,name VARCHAR,position VARCHAR,role VARCHAR,departmentId INT
);
CREATE TABLE news(id SERIAL PRIMARY KEY,departmentId INT,title VARCHAR,news VARCHAR,author VARCHAR
);

CREATE DATABASE department_test WITH TEMPLATE department;

### News-portal
This is an app that involves querying and retrieving scoped news and information.

### Author-name
Glory Kiogora

### Link to gh-pages
https://github.com/Glo18/News-portal.git

### Installation
Install sdk,java,Intellij,heroku CLI,Postgres and Postman.
1.SQL CREATE DATABASE department
2.Create 3 tables department, news, users.
3.CREATE TABLE department (id SERIAL PRIMARY KEY, departmentname VARCHAR, departmentdescription VARCHAR, noofemployees INT)
4.CREATE TABLE news (id SERIAL PRIMARY KEY, username VARCHAR, userposition VARCHAR, userrole VARCHAR, departmentId INT)
5.CREATE TABLE users (id SERIAL PRIMARY KEY, departmentId INT, title VARCHAR, news VARCHAR, author VARCHAR)

### Setup Instructions
Git clone repository--link,move into the directory,cd directory name then open project on code editor.

### License
MIT Copyright (c) 2020 Glory Kiogora

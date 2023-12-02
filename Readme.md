#### Demonstration of JDBC

[Reference video](https://youtu.be/lZbl7Q21t4s)

##### References Libraries

 - `mysql-connector-j-8.2.0`
 
##### Database Environment
 
 - Database: `MySQL`
 - Username: `root`
 - Password: `root`
 - Port: `3306`

##### SQL Statements for creating Database and Table

```
 CREATE DATABASE STUDENT_MGMT;
 USE STUDENT_MGMT;
 CREATE TABLE STUDENTS (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  CITY VARCHAR(50),
  STREAM VARCHAR(20),
  YEAR VARCHAR(4),
  PHONE VARCHAR(12) NOT NULL UNIQUE,
  EMAIL VARCHAR(20) UNIQUE
 )
```
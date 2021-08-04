DROP DATABASE IF EXISTS extra4;
CREATE DATABASE extra4;
USE extra4;

-- create department table
DROP TABLE IF EXISTS Department; 
CREATE TABLE Department (
	departmentNumber			TINYINT UNSIGNED AUTO_INCREMENT  KEY,
    departmentName				VARCHAR(50) NOT NULL UNIQUE KEY
    );
    
-- create employee table 
CREATE TABLE Employee (
	employeeNumber				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    employeeName				VARCHAR(50) NOT NULL,
    departmentNumber 			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (departmentNumber) REFERENCES Department(departmentNumber)
    );
    
-- Create employee skill table
DROP TABLE IF EXISTS Employee_Skill; 
CREATE TABLE Employee_Skill (
	employeeNumber				SMALLINT UNSIGNED NOT NULL ,
    skillCode					VARCHAR(50) NOT NULL,
    dateRegistered 				DATETIME DEFAULT NOW(),
    PRIMARY KEY (employeeNumber, skillCode),
    FOREIGN KEY (employeeNumber) REFERENCES Employee(employeeNumber)
);

-- Question 3: Query all Employee (include: name) who has Java skill
SELECT e.employeeName, es.skillCode
FROM employee e
JOIN employee_skill es ON e.employeeNumber = es.employeeNumber
WHERE es.skillCode = 'Java';

-- Question 4: Query all department which has more than 3 employee
SELECT d.departmentName, COUNT(e.departmentNumber) AS COUNT_EMPLOYEE
FROM department d
JOIN employee e ON d.departmentNumber = e.departmentNumber
GROUP BY e.departmentNumber
HAVING COUNT(e.departmentNumber)  > 3;

-- Question 5: Query all employee of each department.
SELECT d.departmentName, e.employeeName
FROM department d
LEFT JOIN employee e ON d.departmentNumber = e.departmentNumber;

-- Question 6: Query all Employee (include: name) who has more than 1 skills.
SELECT e.employeeName, COUNT(es.skillCode) AS COUNT_SKILL
FROM employee e
JOIN employee_skill es ON e.employeeNumber = es.employeeNumber
GROUP BY es.employeeNumber
HAVING COUNT(es.skillCode) > 1;

USE extra4;

-- INSERT INTO Department using mockaroo
INSERT INTO Department (departmentNumber, departmentName) VALUES (1, 'Services');
INSERT INTO Department (departmentNumber, departmentName) VALUES (2, 'IT');
INSERT INTO Department (departmentNumber, departmentName) VALUES (3, 'Engineering');
INSERT INTO Department (departmentNumber, departmentName) VALUES (4, 'Product Management');
INSERT INTO Department (departmentNumber, departmentName) VALUES (5, 'Marketing');
INSERT INTO Department (departmentNumber, departmentName) VALUES (6, 'Research and Development');
INSERT INTO Department (departmentNumber, departmentName) VALUES (7, 'Sales');
INSERT INTO Department (departmentNumber, departmentName) VALUES (8, 'Accounting');
INSERT INTO Department (departmentNumber, departmentName) VALUES (9, 'Training');
 
-- INSERT INTO employee
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (1, 'Darbie Skylett', 1);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (2, 'Roy Blagdon', 2);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (3, 'Evin Somerled', 3);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (4, 'Denis Jakobsson', 4);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (5, 'Tamqrah Berryann', 5);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (6, 'Caterina Paolino', 6);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (7, 'Whitman Danielli', 2);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (8, 'Fonsie Ruste', 2);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (9, 'Leann Minors', 2);
INSERT INTO Employee (employeeNumber, employeeName, departmentNumber) VALUES (10, 'Veronica Jordeson', 3);


-- INSERT INTO employee skill
INSERT INTO employee_skill (employeeNumber,		skillCode,				dateRegistered)
VALUES
							(1,					'Service Skill',		'2020/03/20'),
                            (2,					'Java',					'2020/04/05'),
                            (2,					'Problem-solving',		'2020/04/07'),
                            (3,					'Industry skills',		'2021/04/30'),
                            (3,					'Teamwork',				'2021/04/30'),
                            (4,					'Communication skills',	'2021/04/30'),
                            (4,					'Technical expertise',	'2021/04/30');
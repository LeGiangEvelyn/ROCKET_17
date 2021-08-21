USE extra6;

-- insert into employee
INSERT INTO employee(employeeLastName,		employeeFirstName,		employeeHireDate,		employeeStatus,		socialSecurityNumber)
VALUES				('Nguyen Van',			'Linh',					'2019/03/04',				1,					123456789),
					('Trinh Minh',			'Tuan',					'2019/08/04',				1,					012345678),
                    ('Le Bao',				'Hien',					'2020/03/09',				1,					737395954),
                    ('Vu Hoang',			'Bao',					'2019/09/04',				1,					957363638),
                    ('Trinh Van',			'Vuong',				'2019/12/04',				1,					585758595),
                    ('Le Van',				'Hau',					'2020/02/08',				1,					736873758),
					('Trinh Van',			'Tu',					'2019/05/04',				0,					756274529);

                    
-- insert into project
INSERT INTO project(managerID,			projectName,				projectDescription,					projectDetailt,		projectModuleCopleteOn)
VALUES				(1,			'Human Resource System',			'Build a HR managerment system',		'afds',			'2021/12/10'),
					(2,			'School System',					'Build a school management system',		'safa',			'2021/05/08'),
                    (3,			'Coffee Order System',				'Build a coffee order system',			'afisfy',		'2022/01/04');
                    
-- insert into projectmodules
INSERT INTO projectmodules(projectID,	employeeID,		projectModuleDate,		projectModuleCopleteOn,		projectModuleDescription)
VALUES						(1,			4,				'2021/06/23',			'2021/06/20',				'Login function'),
							(2,			5,				'2021/03/05',			'2021/03/05',				'Exam management'),
                            (3,			6,				'2021/08/10',			'2021/08/08',				'Order screen');
				
-- nsert into workdone
INSERT INTO workdone(employeeID,	moduleID,		workDoneDate,		workDoneDescription,			workDoneStatus)
VALUES				(4,				1,				'2021/06/01',			'Login screen',					1),
					(4,				1,				'2021/06/10',			'username function',			1),
                    (5,				2,				'2021/03/01',			'question bank',				1);
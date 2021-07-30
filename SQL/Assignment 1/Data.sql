-- INSERT into department
 INSERT into `Department` (department_name) 
VALUES 
							('Sale'),
                            ('Marketing'),
                            ('Human Resource'),
                            ('Purchase'),
                            ('Finance'),
                            ('Operations'),
                            ('Customer Service'),
                            ('Information Technology'); 

-- INSERT into Position
INSERT into `Position` (position_name)
VALUES
						('Dev'),
                        ('Test'),
                        ('Receptionist'),
                        ('PM'),
                        ('Sale Lead'),
						('Maketer'),
                        ('HR'),
                        ('Customer care'),
                        ('Digital Maketer'),
						('Telesale');
                        
-- Insert into Account
INSERT into `Account` (email,				user_name,		full_name,					department_id,	position_id)
VALUES
					('lan0304@gmail.com',	'lan0304',		'Le Thi Lan',					8,				1),
                    ('dung1112@gmail.com',	'dung1112',		'Do Duc Dung',					2,				6),
                    ('mai2307@gmail.com',	'mai2307',		'Nguyen Ngoc Mai',				3,				7),
                    ('duyen0768@gmail.com',	'duyen0768',	'Tran Mai Duyen',				8,				1),
					('tri0809@gmail.com',	'tri0809',		'Le Xuan Tri',					1,				5),
                    ('linh2306@gmail.com',	'linh2306',		'Nguyen Phuong Linh',			7,				8),
                    ('hoa0304@gmail.com',	'hoa0304',		'Nguyen Hong Hoa',				2,				6),
                    ('huong0909@gmail.com',	'huong0909',	'Nguyen Quynh Huong',			8,				4),
                    ('tuan2309@gmail.com',	'tuan2309',		'Nguyen Vi Tuan',				8,				2),
                    ('dung0405@gmail.com',	'dung0405',		'Ngo Dinh Dung',				2,				9),
					('hien5607@gmail.com',	'hien5607',		'Trinh Thu Hien',				1,				10),
                    ('quan4508@gmail.com',	'quan4508',		'Mai Tri Quan',					7,				3),
                    ('duong4567@gmail.com',	'duong4567',	'Nguyen Thu Duong',				3,				7);

-- Insert into Group
INSERT INTO `Group` (group_name,				creator_id)
VALUES	
					('Sale Group',					5),
                    ('Maketing Group',				7),
                    ('HR Group',					3),
                    ('IT Group',					8),
                    ('Customer Group',				6);
			
-- Insert into GroupAcc
INSERT INTO `GroupAccount` (group_id,		account_id,				join_date)
VALUES	
							(	1,				11,					'2021/07/30'),
                            (	2,				2,					'2021/07/30'),
                            (	2,				10,					'2021/08/23'),
                            (	3,				13,					'2021/07/30'),
                            (	4,				1,					'2021/08/30'),
                            (	4,				4,					'2021/08/12'),
                            (	4,				9,					'2021/09/30'),
                            (	5,				12,					'2021/07/30'); 

-- Insert into TypeQuestion
INSERT INTO `TypeQuestion` (type_name)
VALUES
							('Essay'),
                            ('Multiple-Choice');
 
 -- Insert into Category Question
INSERT INTO `CategoryQuestion` (category_name)
VALUES
							('Java'),
                            ('.Net'),
                            ('SQL'),
                            ('Postman'),
                            ('Ruby'); 
                            
-- Insert into question
INSERT INTO `Question` (content,																			category_id,	type_id,	creator_id)	
VALUES	
						('Which of the following option leads to the portability and security of Java?',			1,			2,			1),
                        ('Which of the following is not a Java features?',											1,			2,			1),
                        (' _____ is used to find and fix bugs in the Java programs.',								1,			2,			4),
                        ('Main components of .NET framework?',														2,			1,			4);
                        
                        
-- Insert into Answer
INSERT INTO `Answer` (content,													question_id,	is_correct)
VALUES	
					('a. Bytecode is executed by JVM',								1,				1),
                    ('b. The applet makes the Java code secure and portable',		1,				0),
					('c. Use of exception handling',								1,				0),
                    ('d. Dynamic binding between objects',							1,				0),
                    ('a. Dynamic',													2,				0),
                    ('b. Architecture Neutral',										2,				0),
                    ('c. Use of pointers',											2,				1),
                    ('d. Object- oriented',											2,				0),
                    ('a. JVM',														3,				0),
                    ('b. JRE',														3,				0),
                    ('c. JDK',														3,				0),
                    ('d. JDB',														3,				1),
                    ('Common Language Runtime and Framework Class Library',			4,				1);
                    
	-- Insert into Exam
    INSERT INTO `Exam` (`code`,		title,						category_id,	Duration,	creator_id)
    VALUES
						(101,		'Java Exam',					1,				30,			8),
                        (102,		'.Net Exam',					2,				45,			8);
                        
	-- Insert into Exam Question
    INSERT INTO `ExamQuestion` (exam_id,	question_id)
    VALUES					
								(1,			1),
                                (1,			2),
                                (1,			3),
                                (2,			4);
                    
                    
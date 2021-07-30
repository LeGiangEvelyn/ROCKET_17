DROP DATABASE IF EXISTS `Testing_System_1`;
CREATE DATABASE Testing_System_1;
USE Testing_System_1;

-- Create table department
CREATE TABLE Department (
	department_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 				VARCHAR(50) UNIQUE KEY NOT NULL
);

-- Create table position
CREATE TABLE `Position` (
	position_id				 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name			 		VARCHAR(20) UNIQUE KEY NOT NULL
);

-- Create table account
CREATE TABLE `Account` (
	account_id						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email							VARCHAR(50) UNIQUE KEY NOT NULL,
    user_name						VARCHAR(50) UNIQUE KEY NOT NULL,
    full_name						VARCHAR(50) NOT NULL,
    department_id					TINYINT UNSIGNED NOT NULL,
    position_id						TINYINT UNSIGNED NOT NULL,
    create_date						DATETIME DEFAULT NOW(),
    FOREIGN KEY (department_id) REFERENCES	Department (department_id),
	FOREIGN KEY (position_id) REFERENCES	`Position` (position_id)
);

-- Create table group
CREATE TABLE `Group` (
	group_id						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    group_name						VARCHAR(50) NOT NULL,
    creator_id						SMALLINT UNSIGNED NOT NULL,
	create_date						DATETIME DEFAULT NOW(),
    FOREIGN KEY (creator_id) REFERENCES `Account` (account_id)
);

-- Create table GroupAccount
CREATE TABLE GroupAccount (
	group_id						TINYINT UNSIGNED,
    account_id						SMALLINT UNSIGNED,
	join_date						DATETIME NOT NULL,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `Group` (group_id),
    FOREIGN KEY (account_id) REFERENCES `Account` (account_id)
);

-- Create table TypeQuestion
CREATE TABLE TypeQuestion (
	type_id							TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name						ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

-- Create table CategoryQuestion
CREATE TABLE CategoryQuestion (
	category_id						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    category_name					VARCHAR(20) NOT NULL
);

-- Create table Question
CREATE TABLE Question (
	question_id						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content							VARCHAR(200),
    category_id						TINYINT UNSIGNED NOT NULL,
    type_id							TINYINT UNSIGNED NOT NULL,
    creator_id						SMALLINT UNSIGNED NOT NULL,
	create_date						DATETIME DEFAULT NOW(),
    FOREIGN KEY (category_id) REFERENCES CategoryQuestion(category_id),
	FOREIGN KEY (type_id) REFERENCES TypeQuestion(type_id),
    FOREIGN KEY (creator_id) REFERENCES `Account`(account_id)
);

-- Create table Answer 
CREATE TABLE Answer (
	answer_id						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content							VARCHAR(200) NOT NULL,
	question_id						SMALLINT UNSIGNED NOT NULL,
	is_correct						BIT DEFAULT 0 NOT NULL,
	FOREIGN KEY (question_id) REFERENCES Question (question_id)
);

-- Create Table Exam
CREATE TABLE Exam (
	exam_id							TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code`							TINYINT UNSIGNED NOT NULL,
    title							VARCHAR(200),
    category_id						TINYINT UNSIGNED NOT NULL,
    duration						TINYINT UNSIGNED NOT NULL,
    creator_id						SMALLINT UNSIGNED NOT NULL,
	create_date						DATETIME DEFAULT NOW(),
   FOREIGN KEY (category_id) REFERENCES CategoryQuestion (category_id),
   FOREIGN KEY (creator_id) REFERENCES Account (account_id)
);

-- Create table ExamQuestion
CREATE TABLE ExamQuestion (
	exam_id							TINYINT UNSIGNED NOT NULL,
    question_id						SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (exam_id, question_id),
     FOREIGN KEY (exam_id) REFERENCES Exam (exam_id),
     FOREIGN KEY (question_id) REFERENCES Question (question_id)
);


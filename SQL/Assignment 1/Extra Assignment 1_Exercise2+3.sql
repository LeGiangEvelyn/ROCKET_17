USE Fresher_Training_Management;

-- Exercise 2
CREATE TABLE Data1 (
	data_id			MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`			VARCHAR(50) NOT NULL,
	`code`			CHAR(5),
    modified_date	DATETIME
);

-- Exercise 3
CREATE TABLE Data2 (
	data_id			MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name`			VARCHAR(50),
    birthdate		DATE,
    gender			BIT,
    is_delete_flag	BIT NOT NULL
);

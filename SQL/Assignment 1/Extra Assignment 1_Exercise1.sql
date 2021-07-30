DROP DATABASE IF EXISTS `Fresher_Training_Management`;
CREATE DATABASE Fresher_Training_Management;
USE Fresher_Training_Management;

-- Create table Trainee, et_tq: Entry test point(IQ), et_gmath: Entry test point (Gmath) of trainee
CREATE TABLE Trainee (
	trainee_id			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    full_name			VARCHAR(50) NOT NULL,
    birth_date			DATE,
    gender				ENUM('Male', 'Female', 'Unknown') DEFAULT 'Unknown',
	et_tq				TINYINT UNSIGNED CHECK (et_tq<= 20) NOT NULL,
    et_gmath			TINYINT UNSIGNED CHECK (et_gmath <= 20) NOT NULL,
    et_english			TINYINT UNSIGNED CHECK (et_english <=50) NOT NULL,
    training_class		VARCHAR(10) NOT NULL,
    evaluation_notes	VARCHAR(100)
);

-- Change the table TRAINEE to add vti_acc
ALTER TABLE Trainee
ADD COLUMN vti_account 	SMALLINT UNSIGNED NOT NULL UNIQUE KEY;
DROP DATABASE IF EXISTS extra6;
CREATE DATABASE extra6;
USE extra6;


-- create employee
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
	employeeID					SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    employeeLastName			VARCHAR(50) NOT NULL,
	employeeFirstName			VARCHAR(50) NOT NULL,
    employeeHireDate			DATETIME,
    employeeStatus				BIT DEFAULT 1,
	supervisorID				SMALLINT UNSIGNED,
    socialSecurityNumber		INT NOT NULL UNIQUE KEY,
    FOREIGN KEY (supervisorID) REFERENCES employee(employeeID)
);

-- create table project
DROP TABLE IF EXISTS project;
CREATE TABLE project (
	projectID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    managerID 					SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    projectName					VARCHAR(50) NOT NULL,
	projectDescription			VARCHAR(200),
    projectDetailt				VARCHAR(200),
    projectModuleCopleteOn		DATETIME,
    FOREIGN KEY (managerID) REFERENCES employee(employeeID)
);

-- Create table project modules
DROP TABLE IF EXISTS projectmodules;
CREATE TABLE projectmodules(
	moduleID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    projectID					TINYINT UNSIGNED NOT NULL,
    employeeID					SMALLINT UNSIGNED NOT NULL,
    projectModuleDate			DATETIME,
    projectModuleCopleteOn		DATETIME NOT NULL,
    projectModuleDescription	VARCHAR(200),
    FOREIGN KEY (projectID) REFERENCES project(projectID),
    FOREIGN KEY (employeeID) REFERENCES employee(employeeID)
);

-- create work done
DROP TABLE IF EXISTS workdone;
CREATE TABLE workdone(
	workdoneID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    employeeID					SMALLINT UNSIGNED NOT NULL,
	moduleID					TINYINT UNSIGNED NOT NULL,
    workDoneDate				DATETIME,
    workDoneDescription			VARCHAR(200),
	workDoneStatus				BIT NOT NULL,
	FOREIGN KEY (employeeID) REFERENCES employee(employeeID),
	FOREIGN KEY (moduleID) REFERENCES projectmodules(moduleID)
);

----------------------------------------------------------------------------------------------------------------
-- b) Write a stored procedure (without parameter) to remove the project information after three months of project completion, 
-- since the current date. Print out the number of records which are removed from each related table during the removals.
DROP PROCEDURE delete_project_3month_ago;
DELIMITER $$
CREATE PROCEDURE delete_project_3month_ago()
BEGIN
 -- Khai b??o ra 3 bi???n ????? l??u th??ng tin s??? l?????ng b???n ghi s??? x??a trong c??c b???ng.
 DECLARE remove_project INT(2);
 DECLARE remove_project_modules INT(2);
 DECLARE remove_work_done INT(2);
 
 -- ?????m s??? l?????ng b???n ghi s??? ???????c x??a v?? l??u v??o bi???n
 SELECT count(*) INTO remove_project FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month;
 SELECT count(*) INTO remove_project_modules FROM projectmodules WHERE projectID IN (SELECT projectID FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month);
 SELECT count(*) INTO remove_work_done FROM workdone WHERE moduleID IN (SELECT moduleID FROM projectmodules WHERE projectID IN (SELECT projectID FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month));
 -- ch??n l???nh x??a v??o ????y (l??u ?? x??a t??? workdone -> module -> project)
 DELETE FROM workdone WHERE moduleID IN (SELECT moduleID FROM projectmodules WHERE projectID IN (SELECT projectID FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month));
 DELETE FROM projectmodules WHERE projectID IN (SELECT projectID FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month);
 DELETE FROM project WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month;
 -- In k???t qu??? s??? l?????ng b???n ghi ???????c x??a.
 SELECT 'S??? l?????ng b???n ghi b??? x??a trong project' AS `description`, remove_project
 union
 SELECT 'S??? l?????ng b???n ghi b??? x??a trong project_modules', remove_project_modules
 union
 SELECT 'S??? l?????ng b???n ghi b??? x??a trong work_done', remove_work_done;
END $$
DELIMITER ;
CALL delete_project_3month_ago();

/* WITH get_projectID(projectId) AS(
 SELECT projectID FROM project p WHERE projectModuleCopleteOn < SYSDATE() - interval 3 month
 ) */



-- c) Write a stored procedure (with parameter) to print out the modules that a specific employee has been working on.
DROP PROCEDURE IF EXISTS module_account_working;
DELIMITER $$
CREATE PROCEDURE module_account_working(IN in_name VARCHAR(50), OUT out_module_name VARCHAR(50))
	BEGIN
    DECLARE account_id SMALLINT;
    SELECT employeeID INTO account_id 
			FROM employee WHERE employeeFirstName = in_name;
	SELECT projectModuleDescription INTO out_module_name
			FROM projectmodules 
			WHERE employeeID = account_id;
    END $$
DELIMITER ;
CALL module_account_working('Linh', @out_module_name);
SELECT @out_module_name;

-- d) Write a user function (with parameter) that return the Works information that 
-- a specific employee has been involving though those were not assigned to him/her.

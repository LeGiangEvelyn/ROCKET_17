USE testing_system_assignment_4;
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS get_account_name;
DELIMITER $$
CREATE PROCEDURE get_account_name (IN in_department_name VARCHAR(50))
			BEGIN
            SELECT a.full_name 
            FROM `account` a
            JOIN department d ON a.department_id = d.department_id
            WHERE d.department_name = in_department_name;
			END$$
DELIMITER ;

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS get_amount_of_account;
DELIMITER $$
CREATE PROCEDURE get_amount_of_account (IN group_name VARCHAR(50))
			BEGIN
            SELECT g.group_name, COUNT(ga.account_id) AS amount_of_account
            FROM `group` g
            JOIN groupaccount ga ON g.group_id = ga.group_id
			WHERE g.group_name = group_name;
            END$$
DELIMITER ;
-- Use
/* SET @group_name = 'Sale Group';
CALL get_amount_of_account(@group_name);
SELECT @group_name AS GroupName, @amount_of_account AS AmountOfAccount; */

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS get_count_now_question;
DELIMITER $$
CREATE PROCEDURE get_count_now_question (IN in_type_question VARCHAR(40), OUT out_type_question_name VARCHAR(40) , OUT out_count_now_question TINYINT)
	BEGIN
    SELECT tq.type_name, COUNT(q.question_id)  INTO out_type_question_name, out_count_now_question
	FROM question q
    JOIN typequestion tq ON tq.type_id = q.type_id
	WHERE tq.type_name = in_type_question AND MONTH(create_date) = MONTH(CURRENT_DATE()) AND YEAR(create_date) = YEAR(CURRENT_DATE());
	END $$
DELIMITER ;
CALL get_count_now_question("Essay", @out_name, @out_count);
SELECT @out_name, @out_count;

-- Question 4: Tạo function để trả ra id của type question có nhiều câu hỏi nhất

-- Create function
CREATE OR REPLACE VIEW count_question AS (
		SELECT COUNT(question_id) AS countQuestion
        FROM question
        Group BY type_id);  
        
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS f_max_question;
DELIMITER $$
CREATE FUNCTION f_max_question() RETURNS TINYINT
BEGIN
	DECLARE max_question TINYINT;
	SELECT q.type_id  INTO max_question
	FROM question q
    JOIN typequestion tq ON tq.type_id = q.type_id
    GROUP BY q.type_id
    HAVING COUNT(q.type_id) = (SELECT MAX(countQuestion) 
								FROM count_question) 
	LIMIT 1;
	RETURN max_question;
    END $$
DELIMITER ; 
SELECT F_MAX_QUESTION() AS Type_id;
    
-- Create Procedure    
DROP PROCEDURE IF EXISTS p_max_question;
DELIMITER $$
CREATE PROCEDURE p_max_question(OUT max_question TINYINT) 
BEGIN
	SELECT q.type_id  INTO max_question
	FROM question q
    JOIN typequestion tq ON tq.type_id = q.type_id
    GROUP BY q.type_id
    HAVING COUNT(q.type_id) = (SELECT MAX(countQuestion) 
								FROM count_question) 
	LIMIT 1;
    END $$
DELIMITER ; 
CALL p_max_question(@max_question);
SELECT @max_question AS Type_id;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT type_name AS typeQuestionName
FROM typequestion 
WHERE type_id = @max_question;

/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
chuỗi của người dùng nhập vào */
DROP PROCEDURE IF EXISTS get_account_or_group_name;
DELIMITER $$
CREATE PROCEDURE get_account_or_group_name(IN in_string VARCHAR (50)) 
		BEGIN
        SELECT g.group_name AS GroupNameOrUserName -- INTO out_group_name
        FROM `group` g
        WHERE g.group_name LIKE CONCAT("%",in_string,"%")
        UNION
        SELECT a.full_name -- INTO out_user_name
        FROM `account` a
        WHERE a.full_name LIKE CONCAT("%",in_string,"%");
        END $$
DELIMITER ;
-- CALL get_account_or_group_name("d")

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công */
DROP PROCEDURE IF EXISTS insert_account;
DELIMITER $$
CREATE PROCEDURE insert_account(IN in_fullName VARCHAR(50), IN in_email VARCHAR(200))
	BEGIN
	DECLARE p_username 			VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
	DECLARE p_department_id 	TINYINT UNSIGNED DEFAULT 8;
    DECLARE p_position_id 		TINYINT UNSIGNED DEFAULT 1;
    DECLARE p_create_date		DATETIME DEFAULT NOW();
    INSERT INTO `account` (email, user_name, full_name, department_id, position_id, create_date)
    VALUES 				(in_email,p_username, in_fullName,  p_department_id, p_position_id, p_create_date);
END $$
DELIMITER ;
CALL insert_account('Nguyen Dac Giang', 'giangdac@gmail.com');
SELECT * FROM `account`;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS max_length;
DELIMITER $$
CREATE PROCEDURE max_length (IN essay_or_multipleChoice VARCHAR(20))
	BEGIN
    DECLARE get_type_id TINYINT UNSIGNED;
    SELECT type_id INTO get_type_id
	FROM typequestion
	WHERE type_name = essay_or_multipleChoice;
	WITH get_max_length(get_maxLength) AS(
		SELECT MAX(LENGTH(content))
        FROM question
        WHERE type_id = get_type_id)
	SELECT content
    FROM question
    WHERE length(content) = (SELECT get_maxLength FROM get_max_length);
	END $$
DELIMITER ;
CALL testing_system_assignment_4.max_length('Multiple-Choice');

-- Q9:tore cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS delete_exam;
DELIMITER $$
CREATE PROCEDURE delete_exam (IN in_exam_id TINYINT UNSIGNED)
	BEGIN
	DELETE FROM examquestion WHERE exam_id = in_exam_id;
	DELETE FROM exam WHERE exam_id = in_exam_id;
	END $$
DELIMITER ;

/* Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi
removing */
DROP PROCEDURE IF EXISTS count_record;
DELIMITER $$
CREATE PROCEDURE count_record(OUT count_question TINYINT UNSIGNED, OUT count_exam 	TINYINT UNSIGNED)
	BEGIN
	-- DECLARE count_question TINYINT UNSIGNED;
    -- DECLARE count_exam 		TINYINT UNSIGNED;
    DECLARE get_exam_id		TINYINT UNSIGNED;
    SELECT exam_id INTO get_exam_id FROM exam  WHERE create_date = DATE_SUB(CURRENT_DATE(), INTERVAL 3 YEAR);
    SELECT COUNT(exam_id) INTO count_exam FROM exam  WHERE exam_id = get_exam_id;
	SELECT COUNT(exam_id) INTO count_question FROM examquestion WHERE exam_id = get_exam_id;
    
    DELETE FROM examquestion WHERE exam_id = get_exam_id;
    DELETE FROM exam WHERE exam_id = get_exam_id;
	END $$
DELIMITER ;

CALL count_record(@count_question, @count_exam);
SELECT @count_question;
SELECT @count_exam;
-- SELECT DATE_SUB(CURRENT_DATE(), INTERVAL 3 YEAR);
-- DELETE FROM delete_exam(get_exam_id) ;

/* Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và 
các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc */
DROP PROCEDURE IF EXISTS del_department_by_name;
DELIMITER $$
CREATE PROCEDURE del_department_by_name( IN in_name VARCHAR(50))
	BEGIN
    DECLARE depart_id TINYINT UNSIGNED;
    SELECT department_id INTO depart_id FROM department d WHERE d.department_name = in_name;
    INSERT INTO department (department_id) VALUES (9);
    UPDATE `account` a SET a.department_id = 9 WHERE a.department_id = depart_id;
    DELETE FROM department D WHERE department_id = depart_id;
	END $$
DELIMITER ;

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS sp_CountQuesInMonth; 
DELIMITER $$ 
CREATE PROCEDURE sp_CountQuesInMonth() 
	BEGIN
    WITH CTE_12Months AS ( 
    SELECT 1 AS MONTH 
    UNION SELECT 2 AS MONTH 
    UNION SELECT 3 AS MONTH 
    UNION SELECT 4 AS MONTH 
    UNION SELECT 5 AS MONTH 
    UNION SELECT 6 AS MONTH 
    UNION SELECT 7 AS MONTH 
    UNION SELECT 8 AS MONTH 
    UNION SELECT 9 AS MONTH 
    UNION SELECT 10 AS MONTH 
    UNION SELECT 11 AS MONTH 
    UNION SELECT 12 AS MONTH ) 
    SELECT M.MONTH, count(month(Q.create_date)) AS SL 
    FROM CTE_12Months M 
    LEFT JOIN 
		(SELECT * 
        FROM question Q1 
        WHERE year(Q1.create_date) = year(now()) ) Q ON M.MONTH = month(Q.create_date) 
        GROUP BY M.MONTH; 
	END$$ 
    DELIMITER ;
Call sp_CountQuesInMonth();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")

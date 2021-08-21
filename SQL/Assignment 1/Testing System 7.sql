-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS invalid_group_date;
DELIMITER $$
CREATE TRIGGER invalid_group_date
BEFORE INSERT ON `group`
FOR EACH ROW
	BEGIN
    IF NEW.create_date < (NOW() -  INTERVAL 1 YEAR)
    THEN 
    SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT ="Create Date must be diff. 2020";
    END IF;
	END $$
DELIMITER ;

INSERT INTO `group` (group_name, creator_id, create_date)
VALUES
				("adfc",		4, 		"2020/09/02");
                
-- Q: Tao trigger xóa question id= 4 and delete answer 
DROP TRIGGER IF EXISTS delete_answer;
DELIMITER $$
CREATE TRIGGER delete_answer 
BEFORE DELETE ON answer
FOR EACH ROW 
	BEGIN
    DELETE FROM question WHERE question_id = OLD.question_id;
    DELETE FROM exam WHERE question_id = OLD.question_id;
	END $$
DELIMITER ;
-- DELETE FROM exam WHERE question_id = 4;
DELETE FROM answer WHERE question_id = 4;
-- DELETE FROM 


/* Question 12: Lấy ra thông tin exam trong đó:
Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time" */
SELECT *,
CASE WHEN duration <= 30 THEN "Short time"
	 WHEN duration <= 60 THEN "Medium time"
     ELSE "Long time" 
     END AS Duration
FROM exam;


                
                
/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, 
khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" */
DROP TRIGGER IF EXISTS cannot_add_Sale;
DELIMITER $$
CREATE TRIGGER cannot_add_Sale
BEFORE INSERT ON `account`
FOR EACH ROW
	BEGIN
    WITH get_id(department_id) AS()
    IF 
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
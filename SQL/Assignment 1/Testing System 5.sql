USE testing_system_assignment_4;
-- Q1: LẤy danh sách account thuộc department Sale
CREATE OR REPLACE VIEW saleAccount AS (
	SELECT a.full_name, d.department_name
	FROM `account` a
	JOIN department d ON a.department_id = d.department_id
	WHERE department_name = 'Sale');

-- Q2 có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW count_account AS (
	SELECT COUNT(account_id) AS COUNT_GROUP
	FROM groupaccount ga
	GROUP BY account_id);
        
CREATE OR REPLACE VIEW max_account_group AS(
	SELECT a.full_name, COUNT(GA.account_id) AS COUNT_GROUP
	FROM `account` a
	LEFT JOIN groupaccount GA ON a.account_id = GA.account_id
	HAVING COUNT(GA.account_id) = (SELECT MAX(COUNT_GROUP)
									FROM count_account));
                                    
-- Q3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW contentLong AS
    (SELECT question_id, content 
    FROM question
    WHERE length(content) >= 90);
    
    DELETE q
    FROM question q
    JOIN contentLong c ON q.question_id = c.question_id;
          
-- Q4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW countAccount AS (
	SELECT	COUNT( account_id) AS count_account
	FROM `account` 
    GROUP BY department_id);

/* CREATE VIEW maxAccount AS
	SELECT MAX(count_account) AS `max`
    FROM countAccount; */
    
CREATE OR REPLACE VIEW list_department AS(
	SELECT  d.department_name, COUNT(a.account_id) AS max_account
	FROM department d
	JOIN `account` a ON d.department_id = a.department_id
    GROUP BY a.department_id
	HAVING COUNT(a.account_id) = (SELECT MAX(count_account) 
									FROM countAccount)
);
                                
-- Q5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW get_user_Nguyen AS(
	SELECT account_id, full_name
    FROM `account` 
    WHERE full_name LIKE "Nguyen%"
);
CREATE OR REPLACE VIEW question_by_Nguyen AS (
	SELECT q.content, g.full_name
    FROM `question` q
    JOIN get_user_nguyen g ON q.creator_id = g.account_id
);






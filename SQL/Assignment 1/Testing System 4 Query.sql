USE testing_system_assignment_4;
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `account`
WHERE create_date > 2010/12/20;

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT a.full_name, p.position_name
FROM `account` a
JOIN position p ON a.position_id = p.position_id
WHERE p.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.department_name, COUNT(a.account_id)
FROM department d
JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id
HAVING COUNT(a.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.content, COUNT(e.question_id) as count_question
FROM question q
JOIN examquestion e ON q.question_id = e.question_id
GROUP BY e.question_id;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT c.category_name, COUNT(q.category_id) AS count_category
FROM categoryquestion c 
LEFT JOIN question q ON  c.category_id = q.category_id 
GROUP BY c.category_id;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.content, COUNT(e.question_id) as COUNT_QUESTION
FROM question q
LEFT JOIN examquestion e ON q.question_id = e.question_id
GROUP BY q.question_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT Q.question_id, Q.content, COUNT(A.question_id)
FROM answer A
	INNER JOIN question Q ON Q.question_id = A.question_id
GROUP BY A.question_id
HAVING COUNT(A.question_id) = (SELECT MAX(countQues)
								FROM (SELECT COUNT(a.question_id) AS countQues
										FROM answer a
										GROUP BY a.question_id) AS countAnsw);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT g.group_name, COUNT(ga.account_id) AS COUNT_ACCOUNT
FROM groupaccount GA
JOIN `group` g ON GA.group_id = g.group_id
GROUP BY g.group_id;
/*HAVING COUNT(GA.account_id) = (SELECT MAX(COUNT_ACCOUNT)
								FROM (SELECT COUNT(ga.account_id) AS COUNT_ACCOUNT
										FROM groupaccount ga 
                                        GROUP BY ga.group_id) AS countAccount
);*/

-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.position_name, COUNT(a.account_id) AS COUNT_ACCOUNT
FROM position p 
JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id
HAVING COUNT_ACCOUNT = (SELECT MIN(COUNT_ACCOUNT)
						FROM (SELECT COUNT(A.account_id) AS COUNT_ACCOUNT
								FROM `account` A
                                GROUP BY A.position_id) AS countAccount);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT d.department_name, p.position_name, COUNT(a.position_id) AS COUNT_POSITION
FROM `account` a 
JOIN department d ON a.department_id = d.department_id
JOIN `position` p ON a.position_id = p.position_id
GROUP BY p.position_id;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi,câu trả lời là gì,
SELECT q.question_id, q.content, t.type_name, a.full_name, an.content
FROM question q
JOIN typequestion t ON q.type_id = t.type_id
JOIN `account` a ON q.creator_id = a.account_id
JOIN answer an ON q.question_id = an.question_id
WHERE an.is_correct = 1;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT t.type_name, COUNT(q.type_id)
FROM question q
JOIN typequestion t ON q.type_id = t.type_id
GROUP BY t.type_name;

-- Question 14:Lấy ra group không có account nào 
SELECT g.group_name
FROM `group` g
LEFT JOIN groupaccount ga ON g.group_id = ga.group_id
WHERE ga.group_id IS NULL;

-- Question 15: Lấy ra account không có group nào
SELECT a.account_id, a.full_name
FROM `account` a
LEFT JOIN groupaccount ga ON a.account_id = ga.account_id
WHERE ga.account_id IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT q.content
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
WHERE a.question_id IS NULL;

-- Lay group_name va full_name cua account 
SELECT g.group_name, a.full_name
FROM `group` g
JOIN groupaccount ga ON g.group_id = ga.group_id
JOIN `account` a ON a.account_id = ga.account_id;

/* Question 17:
a) Lấy các account thuộc nhóm thứ 1
b) Lấy các account thuộc nhóm thứ 2
c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau */

SELECT a.account_id, a.full_name
FROM `account` a
JOIN groupaccount g ON a.account_id = g.account_id
WHERE g.group_id = 1
UNION
SELECT a.account_id, a.full_name
FROM `account` a
JOIN groupaccount g ON a.account_id = g.account_id
WHERE g.group_id = 2;






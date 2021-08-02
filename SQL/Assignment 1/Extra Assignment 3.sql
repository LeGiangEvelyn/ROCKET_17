USE fresher_training_management;

-- Question1: Add at least 10 records into created table
INSERT INTO trainee (full_name,					birth_date,		gender,			et_tq,	et_gmath,	et_english,	training_class,	vti_account)
VALUES
					("Le Minh Duc",				"1998/10/12",	"Male",			16,		17,				28,			'DEV2020',	"minhduc1210"),
                    ("Nguyen Thi Mai",			"1997/12/14",	"Female",		17,		14,				35,			'TEST2020',	"mai1412"),
                    ("Trinh Hong Son",			"1998/04/23",	"Male",			18,		18,				40,			'DEV2019',	"son2304"),                   
                    ("Nguyen Hong Thanh",		"1999/06/25",	"Female",		9,		9,				20,			'TEST2019', "thanh2506"),
                    ("Lu Thanh Hai",			"1998/06/24",	"Male",			17,		17,				30,			'DEV2020',	"hai2406"),
                    ('Dao Minh Hong',			'1999/11/29',	"Female",		6,		10,				30,			'TEST2020',	"hong2911"),
                    ('Do Hong Thang',			'2000/12/01',	'Female',		20,		17,				40,			'DEV2021',	"thang0112"),
                    ('Nguyen Thi Ngan',			'1999/03/04',	'Female',		14,		10,				35,			'TEST2020',	'ngan0403');
                    
INSERT INTO trainee (full_name,					birth_date,			et_tq,	et_gmath,	et_english,	training_class,	vti_account)
VALUES              ("Le Minh Khanh",			"1999/05/23",			17,		19,				27,			'DEV2020',	"khanh2305"),     
					("Nguyen Minh Tuan",		"2000/04/30",			7,		8,				16,			'TEST2021',	"tuan3004");
  
  
-- Question 2: Query all the trainees who is passed the entry test, group them into different birth months
-- IQ, Math >= 6 and english >= 5
SELECT *
FROM trainee
WHERE et_tq >=12 AND et_gmath >= 12 AND et_english >= 25
GROUP BY month(birth_date);

-- Question 3: Query the trainee who has the longest name, showing his/her age along with his/her basic information (as defined in the table)
SELECT *, (YEAR(CURRENT_DATE()) - YEAR(birth_date)) AS Age
FROM trainee
WHERE length(full_name) = (SELECT MAX(length(full_name)) FROM trainee);

/* Question 4: Query all the ET-passed trainees. One trainee is considered as ET-passed when he/she has the entry test points satisfied below criteria:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18 */
SELECT *
FROM trainee
WHERE (et_tq + et_gmath) >= 20 AND et_tq >= 8 AND et_gmath >=8 AND et_english >= 18;

-- Question 5: delete information of trainee who has TraineeID = 3
DELETE 
FROM trainee
WHERE trainee_id = 3;

-- Question 6: trainee who has TraineeID = 5 move "2" class. Let update information into database
UPDATE trainee
SET training_class = "2"
WHERE trainee_id = 5;
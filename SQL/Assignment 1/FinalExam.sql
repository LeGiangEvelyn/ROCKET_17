/*1.Tạo table với các ràng buộc và kiểu dữ liệu
Thêm ít nhất 3 bản ghi vào table */
-- Create DB
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE IF NOT EXISTS ThucTap;
-- Use Database
USE ThucTap;

-- Create Table GiangVien
CREATE TABLE 	GiangVien ( 
	maGV	 					INT AUTO_INCREMENT PRIMARY KEY,
	hoten						VARCHAR(50) NOT NULL,
	luong 						INT NOT NULL
);

-- Create Table SinhVien
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE 	SinhVien (
	maSV 						INT AUTO_INCREMENT PRIMARY KEY,
	hoten						VARCHAR(50) NOT NULL ,
	namsinh 					SMALLINT NOT NULL,
	quequan						VARCHAR(50) NOT NULL
);

-- Create Table Detai
CREATE TABLE 	DeTai ( 
	maDT	 					INT AUTO_INCREMENT PRIMARY KEY,
	tendt						VARCHAR(200) NOT NULL ,
	kinhphi						INT NOT NULL,
	noi_thuc_tap				VARCHAR(50) NOT NULL
    );
    
-- Create Table HuongDan
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE 	HuongDan (
	id							INT AUTO_INCREMENT PRIMARY KEY,
	maSV 						INT,
    maDT						INT,
    maGV						INT,
	ketqua						FLOAT(3,1),
    FOREIGN KEY (maSV) REFERENCES SinhVien(maSV) ON DELETE CASCADE,
    FOREIGN KEY (maDT) REFERENCES DeTai(maDT) ,
    FOREIGN KEY (maGV) REFERENCES GiangVien(maGV) 
);

-- INSERT INTO TABLE
INSERT INTO GiangVien(maGV,	hoten,					luong)
VALUES
					(1,		'Le Thi Lan',			13000),
                    (2,		'Nguyen Duc Dung',		14000),
                    (3, 	'Trinh Minh Tuan',		12000),
                    (4,		'Nguyen Thu Hong',		11000);
                    
INSERT INTO SinhVien( maSV,	hoten,					namsinh,	quequan)
VALUES
					(1,		'Nguyen Minh Thu',		1999,		'Ha Noi'),
                    (2,		'Le Van Vuong',			1998,		'Thai Binh'),
                    (3,		'Nguyen Minh Cuong',	1994,		'Yen Bai'),
                    (4,		'Le Thu Hong',			1990,		'Ha Nam'),
                    (5,		'Trinh Duc Dung',		1989,		'Ho Chi Minh');
                    
INSERT INTO DeTai( maDT,	tendt,									kinhphi,	noi_thuc_tap)
VALUES
					(1,		'CONG NGHE SINH HOC',					1200,		'Ha Noi'),
                    (2,		'CONG NGHIEP HOA VA VAN DE VIEC LAM',	1100,		'Binh Duong'),
                    (3, 	'CONG NGHE VA MOI TRUONG',				1400,		'Yen Bai'),
                    (4,		'O NHIEM MOI TRUONG DO THI',			1500,		'Ho Chi Minh');
                    
INSERT INTO HuongDan (id,	maSV,	maDT,	maGV,	ketqua)
VALUES
					(1,		1,		1,		1,		6.8),
                    (2,		3,		2,		2,		8.9),
                    (3,		5,		4,		3,		7.9),
                    (4,		4,		1,		4,		8.0);
                    


/* 2. Viết lệnh để
a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn */
SELECT s.maSV, s.hoten
FROM SinhVien s 
LEFT JOIN HuongDan h ON h.maSV = s.maSV
WHERE h.maSV IS NULL;
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’ 
SELECT COUNT(h.maSV)
FROM HuongDan h
JOIN DeTai d ON h.maDT = d.maDT
WHERE d.tendt LIKE "CONG NGHE SINH HOC";

/* 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có") */
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS(
	SELECT s.maSV, s.hoten, IF(d.tendt IS NULL,"Chưa Có", d.tendt)
	FROM HuongDan h
    JOIN DeTai d ON d.maDT = H.maDT
    RIGHT JOIN SinhVien s ON s.maSV = hzFNMAbm.maSV
);
-- SELECT * FROM sinhvieninfo;

/* 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
thì hiện ra thông báo "năm sinh phải > 1900" */
DROP TRIGGER IF EXISTS invalid_namsinh;
DELIMITER $$
CREATE TRIGGER invalid_namsinh
BEFORE INSERT ON SinhVien
FOR EACH ROW
	BEGIN
    IF NEW.namsinh <= 1900
    THEN 
    SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT ="Năm sinh phải > 1900";
    END IF;  
	END $$
DELIMITER ;

/* INSERT INTO SinhVien ( maSV,	hoten,					namsinh,	quequan)
VALUES
					(7,		'Nguyen Thi Thu',			1890,		'Ha Noi'); */

/* 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi */
/* Set ON DELETE CASECADE ở khóa ngoại maSV của bảng HuongDan*/

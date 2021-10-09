package com.vti.backend;

import com.vti.entity.Account;

import java.time.LocalDate;


public class Exercise1 {
	public static void main(String[] args) {
		 exercise2();
		//question2();

	}
	/* Question 1:
	Khai báo 2 số lương có kiểu dữ liệu là float.
	Khởi tạo Lương của com.vti.entity.Account 1 là 5240.5 $
	Khởi tạo Lương của com.vti.entity.Account 2 là 10970.055$
	Khai báo 1 số int để làm tròn Lương của com.vti.entity.Account 1 và in số int đó ra
	Khai báo 1 số int để làm tròn Lương của com.vti.entity.Account 2 và in số int đó ra */
	public static void question1() {
		float luong1 = (float) 5240.5;
		float luong2 = (float) 10970.055;
		int luongOut1 = (int) luong1;
		int luongOut2 = (int) luong2;
		System.out.println("Luong account1 la: " + luongOut1);
		System.out.println("Luong account2 la: " + luongOut2);
	}
	
	/*Question 1:
	Không sử dụng data đã insert từ bài trước, tạo 1 array com.vti.entity.Account và khởi tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
	 Email: "Email 1"
	 Username: "User name 1"
	 FullName: "Full name 1"
	 CreateDate: now */
	public static void exercise2() {
		Account[] accs = new Account[5];
		for (int i = 0; i < 5; i++) {
			Account acc = new Account();
			acc.email = "Email " +i+1;
			acc.userName = "User name "+ i+1;
			acc.fullName = "Full name "+ i+1;
			acc.createDate = LocalDate.now();
			accs[i] = acc;
		}
		System.out.println(accs[1]);
		for (int i = 0; i < 5; i++) {
			System.out.println("Email: " + accs[i].email + " Username: " + accs[i].userName + " Fullname" + accs[i].fullName + " Create Date: " + accs[i].createDate);
		}
	}

	/*Question 2:
	Khai báo 1 String có value = "1234567"
	Hãy convert String đó ra số int */
	public static void question2() {
		String value = "1234567";
		int convertValue = Integer.parseInt(value);
		System.out.println(convertValue);
	}
}

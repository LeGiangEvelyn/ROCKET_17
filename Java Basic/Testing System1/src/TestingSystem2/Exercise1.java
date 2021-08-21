package TestingSystem2;

import java.time.LocalDateTime;

import Entity.PositionName;
import Entity.Position;
import Entity.Account;
import Entity.Department;
import Entity.Group;


public class Exercise1 {

	public static void main(String[] args) {

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";
		
		Department department2 = new Department();
				department2.id = 2;
				department2.name = "Marketing";
		
		Department department3 = new Department();
				department3.id = 3;
				department3.name = "IT";
				
		//Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.Dev;
		
		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.PM;
		
		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.Test;
		
		//group
		
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		
		//Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "lan@gmail.com";
		account1.userName = "lan1";
		account1.fullName = "Le Thi Lan";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDateTime.now();
		Group[] groupAcc1 = { group1, group2 };
		account1.groups = groupAcc1;
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "locnguyen@gmail.com";
		acc2.userName = "locnguyen";
		acc2.fullName = "Nguyen Ba Loc";
		acc2.department = department2;
		acc2.position = position2;
		acc2.createDate = LocalDateTime.now();
		Group[] groupAcc2 = { group2 };
		acc2.groups = groupAcc2;
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "duongtrinh@gmail.com";
		acc3.userName = "duongtrinh";
		acc3.fullName = "Trinh Ngoc Duong";
		acc3.department = department3;
		acc3.position = position3;
		acc3.createDate = LocalDateTime.now();
		Group[] groupAcc3 = { group2, group3 };
		acc3.groups = groupAcc3;
	//question1(acc2);
	//question2(acc2);
	//question3(acc2);
	//question5(acc2);
	//question8(account1, acc2, acc3);
	//question16(account1, acc2, acc3);
		question17();
	}
	
	
	/* Question 1:
	Kiểm tra account thứ 2
	Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
	Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …" */
	
	public static void question1(Account acc) {
		if (acc.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");}
			else {System.out.println("Phòng ban của nhân viên này là " + acc.department.name);}
		}

	/* Question 2:
	Kiểm tra account thứ 2
	Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group" */
	public static void question2(Account acc)
	{
		if (acc.groups == null) {
			System.out.println("Nhân viên này chưa có nhom");}
		else {
			int groupCount = acc.groups.length;
			if (groupCount == 1 || groupCount == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");}
			else if (groupCount == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");}
		}
	}
	
	public static void question3(Account acc) {
		System.out.println((acc.department == null) ? ("Nhân viên này chưa có phòng ban"):("Phòng ban của nhân viên này là " + acc.department.name));
	}
	//---------------------------------------------------
	
	/* Question 5:
		Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
		Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
		Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
		Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
		Còn lại in ra "Nhóm có nhiều thành viên" */
		public static void question5(Account acc) {
		int countAccount = acc.groups.length;
		switch (countAccount){
			case 1:
			System.out.println("Nhóm có một thành viên");
			break;
			case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
			case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default: 
			System.out.println("Nhóm có nhiều thành viên");
			break;
			}
		}
		
		/* Question 8: For each
		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ */
		
		public static void question8(Account acc1, Account acc2, Account acc3) {
			Account[] accs = { acc1, acc2, acc3 };
			for (Account account : accs) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);	
			}
		}
		
		/* Question 10: For
		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
		Thông tin account thứ 1 là:
		Email: NguyenVanA@gmail.com
		Full name: Nguyễn Văn A
		Phòng ban: Sale
		Thông tin account thứ 2 là:
		Email: NguyenVanB@gmail.com
		Full name: Nguyễn Văn B
		Phòng ban: Marketting */
		
		public static void question10(Account acc1, Account acc2, Account acc3){
			Account[] accs = { acc1, acc2, acc3 };
			for (int i = 0 ; i < accs.length; i++) {
				System.out.println("Thông tin account thứ " + (i+1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.name);
			}
		}
		
		/*Question 16: While
		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue */
		public static void question16(Account acc1, Account acc2, Account acc3) {
			Account[] accs = {acc1, acc2, acc3};
			int i = 0;
			while (i < accs.length) {
				System.out.println("Thông tin account thứ " + (i+1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.name);
				i++;
			}
		}
		 
		/*Question 17-15: Do WHILE 
			In ra các số chẵn nhỏ hơn hoặc bằng 20 */
		public static void question17() {
			int i = 0;
			do {	
				if (i % 2 == 0) { System.out.println(i + " ");}
				i++;
			} while (i <= 20);
		}
		
}
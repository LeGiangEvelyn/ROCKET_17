import java.time.LocalDateTime;
import java.util.Scanner;

import Entity.Account;
import Entity.Department;
import Entity.Group;
import Entity.Position;
import Entity.PositionName;

public class Exercise5 {
	public static void main(String[] args) {
		// question1();
		// question5();
		//question8();
		flow9();
	}

	/*
	 * Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	 */
	public static void question1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 3 so nguyen: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("3 So vua nhap la: " + a + " " + b + " " + c);
	}

	/*
	 * Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method) Đối
	 * với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ
	 * chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
	 */
	public static void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Create Account: ");
		Account acc = new Account();
		System.out.println("Enter id: ");
		acc.id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter email: ");
		acc.email = sc.nextLine();

		System.out.println("Enter userName: ");
		acc.userName = sc.nextLine();
		System.out.println("Enter fullname: ");
		acc.fullName = sc.nextLine();
		System.out.println("Enter Position 1,2,3,4 As Dev, Test, Scrum Master and PM");
		int i = sc.nextInt();
		position(i, acc);
		System.out.printf("%n%d| %-30s| %-30s| %-30s| ", acc.id, acc.email, acc.fullName, acc.position.name);
	}

	public static void position(int i, Account acc) {
		switch (i) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.Dev;
			acc.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.Test;
			acc.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.ScrumMaster;
			acc.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.position = pos4;
			break;
		}
	}

	/*
	 * Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
	 */
	public static void createDepartment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Create Department: ");
		Department department = new Department();
		System.out.println("Enter id:");
		department.id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter department name:");
		department.name = sc.nextLine();
		System.out.printf("%n%d| %-30s| ", department.id, department.name);
	}

	/*
	 * Question 8: Viết chương trình thực hiện theo flow sau: Bước 1: Chương trình
	 * in ra text "mời bạn nhập vào chức năng muốn sử dụng" Bước 2: Nếu người dùng
	 * nhập vào 1 thì sẽ thực hiện tạo account Nếu người dùng nhập vào 2 thì sẽ thực
	 * hiện chức năng tạo department Nếu người dùng nhập vào số khác thì in ra text
	 * "Mời bạn nhập lại" và quay trở lại bước 1
	 */
	public static void question8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
		int i = sc.nextInt();
		do {
			if (i == 1) {
				createAccount();
				break;
			} else if (i == 2) {
				createDepartment();
				break;
			} else {
				System.out.println("Mời bạn nhập lại: ");
				question8();
			}
		} while (i == 1 || i == 2);

	}
	/*
	 * Question 9: Viết method cho phép người dùng thêm group vào account theo flow
	 * sau: Bước 1: In ra tên các usernames của user cho người dùng xem Bước 2: Yêu
	 * cầu người dùng nhập vào username của account Bước 3: In ra tên các group cho
	 * người dùng xem Bước 4: Yêu cầu người dùng nhập vào tên của group Bước 5: Dựa
	 * vào username và tên của group người dùng vừa chọn, hãy thêm account vào group
	 * đó .
	 */

	public static void flow9() {
		//group
		Scanner sc = new Scanner(System.in);
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
		account1.createDate = LocalDateTime.now();
		
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "locnguyen@gmail.com";
		acc2.userName = "locnguyen";
		acc2.fullName = "Nguyen Ba Loc";
		acc2.createDate = LocalDateTime.now();
		
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "duongtrinh@gmail.com";
		acc3.userName = "duongtrinh";
		acc3.fullName = "Trinh Ngoc Duong";
		acc3.createDate = LocalDateTime.now();
		Account[] accs = { account1, acc2, acc3 };
		Group[] groups = { group1, group2, group3 };
		System.out.println("List username: "+account1.userName + "| " +acc2.userName + "| " + acc3.userName);
		System.out.println("Choose 1 username you wnat to add into group: ");
		String inputName = sc.nextLine();
		System.out.println("List group: "+ group1.name + "| " + group2.name + "| " + group3.name);
		System.out.println("Choose 1 group name you want to add account: ");
		String inputGroup = sc.nextLine();
		
		int indexAcc = -1;
		for (int i=0; i < accs.length; i++ ) {
			if (accs[i].userName.equals(inputName)) {
				indexAcc = i;
			}
		}
		int indexGroup = -1;
		for (int i=0; i < groups.length; i++ ) {
			if (groups[i].name.equals(inputGroup)) {
				indexGroup = i;
			}
		}
		if (indexAcc < 0 || indexGroup <0) {
			System.out.println("Enter wrong username or group name!");
		} else {
			for (int j = 0; j < accs.length; j++) {
				if (accs[j].userName.equals(inputName)) {
				Group[] gpAdd = { groups[indexGroup] };
				accs[j].groups = gpAdd;
				System.out.println("Bạn vừa Add group: " + accs[indexAcc].groups[0].name + " cho Account: "
				+ accs[indexAcc].userName);
				}
		}
		}
	}
}

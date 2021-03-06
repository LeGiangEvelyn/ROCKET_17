

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
	Ki???m tra account th??? 2
	N???u kh??ng c?? ph??ng ban (t???c l?? department == null) th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? ph??ng ban"
	N???u kh??ng th?? s??? in ra text "Ph??ng ban c???a nh??n vi??n n??y l?? ???" */
	
	public static void question1(Account acc) {
		if (acc.department == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? ph??ng ban");}
			else {System.out.println("Ph??ng ban c???a nh??n vi??n n??y l?? " + acc.department.name);}
		}

	/* Question 2:
	Ki???m tra account th??? 2
	N???u kh??ng c?? group th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? group"
	N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra text "Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher"
	N???u c?? m???t trong 3 Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group"
	N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group" */
	public static void question2(Account acc)
	{
		if (acc.groups == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? nhom");}
		else {
			int groupCount = acc.groups.length;
			if (groupCount == 1 || groupCount == 2) {
				System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");}
			else if (groupCount == 3) {
				System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");}
		}
	}
	
	public static void question3(Account acc) {
		System.out.println((acc.department == null) ? ("Nh??n vi??n n??y ch??a c?? ph??ng ban"):("Ph??ng ban c???a nh??n vi??n n??y l?? " + acc.department.name));
	}
	//---------------------------------------------------
	
	/* Question 5:
		L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format sau:
		N???u s??? l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n"
		N???u s??? l?????ng account = 2 th?? in ra "Nh??m c?? hai th??nh vi??n"
		N???u s??? l?????ng account = 3 th?? in ra "Nh??m c?? ba th??nh vi??n"
		C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n" */
		public static void question5(Account acc) {
		int countAccount = acc.groups.length;
		switch (countAccount){
			case 1:
			System.out.println("Nh??m c?? m???t th??nh vi??n");
			break;
			case 2:
			System.out.println("Nh??m c?? hai th??nh vi??n");
			break;
			case 3:
			System.out.println("Nh??m c?? ba th??nh vi??n");
			break;
		default: 
			System.out.println("Nh??m c?? nhi???u th??nh vi??n");
			break;
			}
		}
		
		/* Question 8: For each
		In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a h??? */
		
		public static void question8(Account acc1, Account acc2, Account acc3) {
			Account[] accs = { acc1, acc2, acc3 };
			for (Account account : accs) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);	
			}
		}
		
		/* Question 10: For
		In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a h??? theo ?????nh d???ng nh?? sau:
		Th??ng tin account th??? 1 l??:
		Email: NguyenVanA@gmail.com
		Full name: Nguy???n V??n A
		Ph??ng ban: Sale
		Th??ng tin account th??? 2 l??:
		Email: NguyenVanB@gmail.com
		Full name: Nguy???n V??n B
		Ph??ng ban: Marketting */
		
		public static void question10(Account acc1, Account acc2, Account acc3){
			Account[] accs = { acc1, acc2, acc3 };
			for (int i = 0 ; i < accs.length; i++) {
				System.out.println("Th??ng tin account th??? " + (i+1) + " l??:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Ph??ng ban: " + accs[i].department.name);
			}
		}
		
		/*Question 16: While
		L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng WHILE k???t h???p v???i l???nh break, continue */
		public static void question16(Account acc1, Account acc2, Account acc3) {
			Account[] accs = {acc1, acc2, acc3};
			int i = 0;
			while (i < accs.length) {
				System.out.println("Th??ng tin account th??? " + (i+1) + " l??:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Ph??ng ban: " + accs[i].department.name);
				i++;
			}
		}
		 
		/*Question 17-15: Do WHILE 
			In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20 */
		public static void question17() {
			int i = 0;
			do {	
				if (i % 2 == 0) { System.out.println(i + " ");}
				i++;
			} while (i <= 20);
		}
		
}
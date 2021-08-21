import java.time.LocalDateTime;

import Entity.Account;
import Entity.Group;

public class Exercise2 {

	public static void main(String[] args) {
	/* Question 1:
	Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó */
		int i = 5;
		System.out.printf("%d",i);
	/* Question 2:
	Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000 */
		int i2 = 100000000;
		System.out.printf("%, d%n", i2);
	/*Question 3:
	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau */
		double i3 = 5.567098;
		System.out.printf("%.4f%n", i3);
	/* Question 4:
	Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
	Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
	Tên tôi là "Nguyễn Văn A" và tôi đang độc thân. */
		String s = "Nguyễn Văn A"; 
		System.out.printf("Tên tôi là \"" + s + "\" và tôi đang độc thân \n");
	/* Question 6:
		In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database) */
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "lan@gmail.com";
		acc1.userName = "lan1";
		acc1.fullName = "Le Thi Lan";
		acc1.createDate = LocalDateTime.now();
		
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
		
			Account[] accs = { acc1, acc2, acc3 };
			for (Account account : accs) {
			System.out.printf("%n%d| %-30s| %-30s ", account.id, account.email, account.fullName );	
			}
		}
		
	}

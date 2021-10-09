package com.vti.backend;

import java.util.Locale;
import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
		question1();
		//question2();
		//question4();
		//question5();
		//question7();
		//question8();
	}
	
	
	
		/* Question 1:
	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng ); */
	public static void question1() {
		String str;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String: ");
		str = scanner.nextLine();
		//Standardized string
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		//get words
		String[] words = str.split(" ");
		System.out.println("Amount of word(s): " + words.length);
		scanner.close();
		}
	
	/*
	Question 2:
	Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1; */
	public static void question2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String 1: ");
		String s1 = sc.nextLine();
		System.out.println("Enter String 2: "); 
		String s2 = sc.nextLine();
		System.out.println("Kết quả sau khi nối chuỗi: " + s1 + " " + s2);
		sc.close();
		}
	
	/*
	Question 3:
	Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết hoa chữ cái đầu thì viết hoa lên */
	public static void question3() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("Enter Name: ");
		name = sc.nextLine();
		String firstCharacter = name.substring(0, 1).toUpperCase();
		String leftCharacter = name.substring(1);
		System.out.println("char at:" + name.charAt(1));
		name = firstCharacter + leftCharacter;
		System.out.println(name);
		sc.close();
	}
	/*
	Question 4:
	Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
	VD:
	Người dùng nhập vào "Nam", hệ thống sẽ in ra
	"Ký tự thứ 1 là: N"
	"Ký tự thứ 1 là: A"
	"Ký tự thứ 1 là: M"
	*/
	public static void question4() { 
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("Enter String: ");
		str = sc.nextLine();
		
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			System.out.println("Ky tu thu " + (i+1) + " la: " +str.charAt(i));
		}
		sc.close();
	}
	
	/*
	Question 5:
	Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ */
	public static void question5() {
		Scanner sc = new Scanner(System.in);
		String lName, fName;
		System.out.println("Enter Lastname: ");
		lName = sc.nextLine();
		System.out.println("Enter Firstname: ");
		fName = sc.nextLine();
		
		System.out.println("Fullname: " + lName + " " + fName);
		sc.close();
	}
	
	/*
	Question 6:
	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm
	VD:
	Người dùng nhập vào "Nguyễn Văn Nam"
	Hệ thống sẽ in ra
	"Họ là: Nguyễn"
	"Tên đệm là: Văn"
	"Tên là: Nam" */
	public static void question6() {
		Scanner sc = new Scanner(System.in);
		String name = "", lName = "", fName = "", mName ="";
		System.out.println("Enter Fullname: ");
		name = sc.nextLine();
		name = name.trim();
		String[] words = name.split(" ");
		lName = words[0];
		fName = words[words.length-1];
		for (int i = 1; i< words.length-1; i++){
			mName += words[i] + " ";
		}
		System.out.println("Firstname: " + fName);
		System.out.println("Lastname: " + lName);
		System.out.println("Middle Name: " + mName);
		sc.close();
	}
	/*
	Question 7:
	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
	3
	VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn nam"
	b) Viết hoa chữ cái mỗi từ của người dùng
	VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam" */
	public static void question7() {
		Scanner sc = new Scanner(System.in);
		String name = "";
		System.out.println("Enter Fullname: ");
		name = sc.nextLine();
		//a. Xâu “\\s+” là một xâu đặc biệt trong Java. Xâu này là định nghĩa cho xâu gồm tất cả các khoảng trắng liên tục.
		name = name.trim().toLowerCase();
		name = name.replace("\\s+", " ");
		//b. split into words then upper case first character
		String[] words = name.split(" ");
		name = "";
		for (int i = 0; i< words.length; i++){
			String s1 = words[i].substring(0,1).toUpperCase(); //upper case first char
			words[i] = s1 + words[i].substring(1);
		}
		for (int i = 0; i< words.length; i++){
			name += words[i];
			if (i< words.length -1) {
				name += " ";
			}
		}
		System.out.println(name);
		System.out.println("`"+ name + "`");
		sc.close();
	}


	/*
	Question 8:
	In ra tất cả các group có chứa chữ "Java" */
	public static void question8() {
		String[] groupNames = { "Java Dev", "Java Test", "group learning" };
		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}
}

package com.vti.frontend;

import com.vti.entity.Student;

public class Question1_Ex4 {
	public void printStudent() {
		Student stu1 = new Student("Le Thi Lan", "Hanoi");
		stu1.plusScore(5f);
		Student stu2 = new Student("Tran Long", "BG");
		stu2.plusScore(9f);
		Student stu3 = new Student("Hoa", "HG");
		stu3.plusScore(4f);
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
	}

}

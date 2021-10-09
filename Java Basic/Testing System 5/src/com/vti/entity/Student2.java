package com.vti.entity;

import java.util.Scanner;

public class Student2 extends Person{
    /*Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên: Mã sinh viên, Điểm trung bình, Email
	a) Override phương thức inputInfo(), nhập thông tin Student từ bàn phím
	b) Override phương thức showInfo(), hiển thị tất cả thông tin Student
	c) Viết phương thức xét xem Student có được học bổng không? Điểm trung bình từ 8.0 trở lên là được học bổng */
    private int id;
    private Float avgScore;
    private String email;

    @Override
    public void inputInfor() {
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.println("ID: ");
        this.id = sc.nextInt();
        System.out.println("Average Score: ");
        this.avgScore = sc.nextFloat();
        System.out.println("email: ");
        this.email = sc.next();
    }

    @Override
    public String showInfor() {
        return super.showInfor() + " id= " + id + ", gradeAvg=" + avgScore + ", email=" + email + "]";
    }

    public boolean Scholarship() {
        return avgScore > 8.0 ? true : false;
    }

}

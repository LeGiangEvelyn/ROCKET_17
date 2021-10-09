package com.vti.backend;

import com.vti.entity.Student;

public class Exercise1 {
    /*Khai báo 1 class student có các thuộc tính id, name, college
    Với college là static variable. Hãy khởi tạo các student sau:
    Student có id = 1, name ="Nguyễn Văn A"
    Student có id = 2, name = " Nguyễn Văn B "
    Student có id = 3, name = " Nguyễn Văn C "
    Và tất cả các student này đều học ở "Đại học bách khoa".
    Dùng vòng for để in ra thông tin các student Sau đó hãy chuyển các student này sang "Đại học công nghệ"
    Dùng vòng for để in ra thông tin các student */
    public static void question1() {
        Student[] students = new Student[3];
        Student student1 = new Student(1, "Nguyen Van A");
        Student student2 = new Student(2,"NGuyen Van B");
        Student student3 = new Student(3,"NGuyen Van C");
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        System.out.println("Thong tin sinh vien: ");
        for (int i = 0; i < students.length; i++){
            System.out.println(students[i].toString());
        }
        System.out.println("Chuyen Sang Dai hoc Cong nghe");
        Student.collect = "Dai hoc Cong nghe";
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }

    /* Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ lớp - dùng chung cho tất cả các student).
    Hãy viết chương trình main() để mô tả các bước sau:
    B1: Các Student sẽ nộp quỹ, mỗi Student 100k
    B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
    B3: Student thứ 2 lấy 20k đi mua bánh mì
    B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
    B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
    In ra số tiền còn của nhóm tại mỗi bước
     */
    public static void question2(){
        Student[] students = new Student[3];
        Student student1 = new Student(1, "Nguyen Van A");
        Student student2 = new Student(2,"NGuyen Van B");
        Student student3 = new Student(3,"NGuyen Van C");
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        System.out.println("Tien quy lop: " + Student.getMoneyGroup());
        int temp = Student.getMoneyGroup();
        temp -= 50;
        System.out.println("Student thứ 1 lấy 50k đi mua bim bim, tien quy con: " + temp);
        temp -=20;
        System.out.println("Student thứ 2 lấy 20k đi mua bánh mì, tien quy con: "+temp);
        temp -=150;
        System.out.println("Student 3 lay 150k di mu do hoc tap, tien quy con: "+ temp);
        temp += 50*3;
        System.out.println("Moi nguoi them 50k, tien quy la: "+ temp);
        Student.setMoneyGroup(temp);
    }

    /* a. Viết class MyMath để thay thế cho class Math của java.
    b) Viết thêm method min(), sum vào class MyMath */



}

package com.vti.backend;

import com.vti.entity.Department;

public class Exercise5 {
    public static void main(String[] args) {
        Department[] departments = new Department[2];
        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Sale");
        Department department2 = new Department();
        department2.setId(2);
        department2.setName("Marketing");
        Department department3 = new Department();
        department3.setId(3);
        department3.setName("Accounting");
        Department department4 = new Department();
        department3.setId(4);
        department3.setName("IT");
        Department department5 = new Department();
        department3.setId(5);
        department3.setName("Boss of director");

        departments[0] = department1;
        departments[1] = department2;
        departments[2] = department3;
        departments[3] = department4;
        departments[4] = department5;
        //question1(department1);
        //question2(departments);
        //question3(department1);
        question5(department1, department2);
    }

    /* Question 1:
    In ra thông tin của phòng ban thứ 1 (sử dụng toString()) */
    public static void question1(Department department) {
        System.out.println(department.toString());
    }

    /*
    Question 2:
    In ra thông tin của tất cả phòng ban (sử dụng toString()) */
    public static void question2(Department[] departments) {
        for (Department department : departments) {
            System.out.println(department.toString());
        }
    }
    /*
    Question 3:
    In ra địa chỉ của phòng ban thứ 1 */

    public static void question3(Department department) {
        System.out.println(department.hashCode());
    }

    /*
    Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không? */
    public static void question4(Department department) {
        if (department.getName().equals("Phòng A")) {
            System.out.println("Department 1 name Phong A");
        } else {
            System.out.println("Department 1 does not name Phong A");
        }
    }

    /*
    Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau) */
    public static void question5(Department department1, Department department2) {
        if (department1.getName().equals(department2.getName())) {
            System.out.println("Department 1 is equal to department 2");
        } else {
            System.out.println("Department 1 is not equal to department 2");
        }
    }

    /*
    Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
    VD:
    Accounting
    Boss of director
    Marketing
    Sale
    Waiting room */
    public static void question6(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments.length - 1; j++) {
                if (departments[i].getName().compareToIgnoreCase(departments[j].getName()) < 0) {
                    // swap 2 department
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }

    }
}

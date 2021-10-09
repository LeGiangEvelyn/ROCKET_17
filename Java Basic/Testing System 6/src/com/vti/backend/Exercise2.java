package com.vti.backend;

import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

import java.util.Scanner;

public class Exercise2 {

    public static void question2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        try {
            float result = divide(a, b);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Cannot divide 0!");
        } finally {
            System.out.println("Divide completed!");
        }

    }

    public static float divide(int a, int b) {
        return a / b;
    }

    public static void question3() {
        int[] numbers = {2, 3, 5};
        try {
            System.out.println(numbers[10]);
        } catch (Exception e) {
            System.err.println("The array's not include this index!");
        }
    }

    /* Question 4:
    Tạo 1 array departments gồm 3 phần tử
    Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ index trong array departments.
    Nếu index vượt quá length lấy ra thì sẽ in ra text "Cannot find department."
     */
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index: ");
        int input = sc.nextInt();
        Department dep1 = new Department("Dep1");
        Department dep2 = new Department("Dep2");
        Department dep3 = new Department("Dep3");
        Department dep4 = new Department("Dep4");
        Department[] departments = {dep1, dep2, dep3, dep4};
        try {
            getIndex(input);
        } catch (Exception e) {
            System.err.println("Cannot find this index in the array!");
        }
        sc.close();
    }

    public static void getIndex(int index) {
        Department[] departments = new Department[3];
        System.out.println(departments[index].toString());
    }

    /* Tạo 1 method inputAge() và trả về 1 số int.
    Trong method hãy cài đặt như sau:
    B1: Sau đó dùng scanner để nhập vào 1 số
    B2: Check exeption
    Nếu người dùng nhập vào 1 số thì return về số đó
    Nếu người dùng không nhập vào 1 số thì sẽ in ra dòng text "wrong inputting! Please input an age as int, input again."
    Nếu người dùng không nhập vào 1 số < 0 thì sẽ in ra dòng text
    "Wrong inputting! The age must be greater than 0, please input again."
    B3: hãy demo trong method main() */
    public static void question5() {
        System.out.println("Nhập vào tuổi của sinh viên: ");
        int age = ScannerUtils.inputIntPositive();
        System.out.println("Tuổi của sinh viên là: " + age);
    }

    public static int inputAge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age: ");
        int input = sc.nextInt();
        while (true) {
            try {
                if (input < 0) {
                    System.err.println("Wrong inputting! The age must be greater than 0, please input again.");
                }
            } catch (Exception e) {
                System.err.println("wrong inputting! Please input an age as int, input again.");
            }
            return input;
        }
    }

}

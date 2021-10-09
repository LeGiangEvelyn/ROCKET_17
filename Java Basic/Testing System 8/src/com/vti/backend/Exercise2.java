package com.vti.backend;

import com.vti.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise2 {
    public static void question1(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Lan Anh", "20/03/2004", 3.5f));
        students.add(new Student(2, "Mai Anh", "20/03/2002", 9f));
        students.add(new Student(3, "Le Thi Lan", "10/03/2004", 6f));
        students.add(new Student(4, "Do Dung", "20/08/2001", 7f));
        students.add(new Student(5, "Ngoc Anh", "20/12/2004", 8f));

        Collections.sort(students);
        for (Student student : students){
            System.out.println(student);
        }
    }
}

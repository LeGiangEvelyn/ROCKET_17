package com.vti.backend;

import com.vti.entity.Student1;

public class Exercise3 {
    public static void question1(){
        Student1<Integer> student1 = new Student1<Integer>(1, "Nam");
        Student1<Float> student2 = new Student1<Float>(2f,"Lan");
        Student1<Double> student3 = new Student1<Double>(3.0,"Mai");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}

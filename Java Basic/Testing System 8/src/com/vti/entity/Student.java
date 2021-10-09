package com.vti.entity;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String dob;
    private float score;


    public Student(){

    }
    public Student(int id, String name, String dob, float score){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.score = score;

    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }


    @Override
    public int compareTo(Student student) {
        if (name.compareTo(student.name)> 0) {
            return 1;
        } else if (name.compareTo(student.name)< 0){
            return -1;
        }
        return 0;
    }
}

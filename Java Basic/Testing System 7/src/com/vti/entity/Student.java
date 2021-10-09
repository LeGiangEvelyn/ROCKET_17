package com.vti.entity;

public class Student {
    private int id;
    private String name;
    public static String collect;
    private static int moneyGroup;


    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }


    public Student(int id, String name){
        this.id = id;
        this.name = name;
        collect = "Đại học Bách Khoa";
        moneyGroup += 100;

    }

    @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + " collect:" + collect +"]";
    }
}

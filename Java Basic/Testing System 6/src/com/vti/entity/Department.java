package com.vti.entity;

public class Department {
    public static int count;
    private int id;
    private String name;

    public Department(String name) {
        super();
        count++;
        this.id = count;
        this.name = name;
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
}

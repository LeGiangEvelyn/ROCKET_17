package com.vti.entity;

import java.util.Comparator;

public class Department implements Comparator<Department> {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override // ghi đè phương thức compare của Interface Comparator
    public int compare(Department o1, Department o2) {
        return o1.name.compareTo(o2.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Department department = (Department) o;
        if (name.equals(department.name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
    }


}

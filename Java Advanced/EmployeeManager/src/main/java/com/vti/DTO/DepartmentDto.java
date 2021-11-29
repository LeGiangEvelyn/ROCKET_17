package com.vti.DTO;

public class DepartmentDto {
    private short id;

    private String name;

    private int totalNumber;

    public DepartmentDto(short id, String name, String totalNumber) {
        this.id = id;
        this.name = name;
        this.address = totalNumber;
    }

    public DepartmentDto(){

    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalNumber() {
        return totalNumber;
    }
}

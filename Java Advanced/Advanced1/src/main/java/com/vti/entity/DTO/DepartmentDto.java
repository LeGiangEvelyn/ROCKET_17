package com.vti.entity.DTO;

public class DepartmentDto {
    private short id;

    private String name;

    private String address;

    public DepartmentDto(short id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }
}

package com.vti.entity.DTO;

public class DepartmentDto {
    private short id;

    private String name;

//    private AddressDto address;


    public DepartmentDto(short id, String name) {
        this.id = id;
        this.name = name;
//        this.address = address;
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

    //    public AddressDto getAddress() {
//        return address;
//    }
}

package com.vti.entity.DTO;

import com.vti.entity.Address;


public class DetailDepartmentDto {
    private short id;

    private String name;

    private AddressDto address;


    public DetailDepartmentDto(short id, String name, AddressDto address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AddressDto getAddress() {
        return address;
    }
}

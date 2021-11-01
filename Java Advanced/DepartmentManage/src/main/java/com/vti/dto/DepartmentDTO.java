package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DepartmentDTO {
	private short id;

	private String name;

	private AccountDto author;
	
	private AddressDto address;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;

	public DepartmentDTO(short id, String name, AccountDto author, Date createDate, AddressDto address) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.createDate = createDate;
		this.address = address;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public AccountDto getAuthor() {
		return author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

}

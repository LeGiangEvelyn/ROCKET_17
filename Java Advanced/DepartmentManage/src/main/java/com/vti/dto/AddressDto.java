package com.vti.dto;

public class AddressDto {
	private short id;
	String addressName;
	
	
	public AddressDto(short id, String addressName) {
		this.id = id;
		this.addressName = addressName;
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
}

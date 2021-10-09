package com.vti.entity;

public class CongNhan extends CanBo{
	int bac;
	public CongNhan(String hoten, int tuoi, GioiTinh gioitinh, String diachi, int bac) {
		super(hoten, tuoi, gioitinh, diachi);
		this.bac = bac;
	}
}

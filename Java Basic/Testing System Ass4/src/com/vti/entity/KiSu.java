package com.vti.entity;

public class KiSu extends CanBo{
	private String nganhDT;
	public KiSu(String hoten, int tuoi, GioiTinh gioitinh, String diachi, String nganhDT) {
		super(hoten, tuoi, gioitinh, diachi);
		this.nganhDT = nganhDT;
	}
}

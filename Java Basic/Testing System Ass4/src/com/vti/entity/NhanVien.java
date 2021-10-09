package com.vti.entity;

public class NhanVien extends CanBo{
	private String congviec;
	public NhanVien(String hoten, int tuoi, GioiTinh gioitinh, String diachi, String congviec) {
		super(hoten, tuoi, gioitinh, diachi);
		this.congviec = congviec;
	}
}

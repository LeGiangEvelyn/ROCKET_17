package com.vti.entity;

public class CanBo {
	private String hoten;
	private int tuoi;
	private GioiTinh gioitinh;
	private String diachi;
	
	public CanBo(String hoten, int tuoi, GioiTinh gioitinh, String diachi) {
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public GioiTinh getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(GioiTinh gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}

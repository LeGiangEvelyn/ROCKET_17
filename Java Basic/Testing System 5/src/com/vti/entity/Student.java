package com.vti.entity;

public class Student implements IStudent{
/* 	Tạo 1 class Student gồm các property id, name, group(int)*/
	private int id;
	private String name;
	private int group;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh.");
	}

	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài.");
	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " đi dọn vệ sinh.");
	}

	public Student(String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}
}

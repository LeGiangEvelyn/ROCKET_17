package vti.com.entity;

import java.time.LocalDateTime;


public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private LocalDateTime createDate;
	private Group[] groups;
	
	public Account(){	
	}
	public Account(int id, String email, String userName, String fullName, Department department, Position position, LocalDateTime createDate ) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.setPosition(position);
		this.setCreateDate(createDate);
	}
	
	public int getId() {
		return this.id;
	}
	public String getEmail() {
		return this.email;
	}
	public String getUsername() {
		return this.userName;
	}
	public String getFullname() {
		return this.fullName;
	}
	public Department getDepartment() {
		return this.department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Group[] getGroups() {
		return groups;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
	
	
}

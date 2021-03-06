package vti.com.entity;

import java.time.LocalDateTime;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private LocalDateTime createDate;
	private Account[] accounts;
	public Group() {
		
	}
	public Group(int id, String name, Account creator, LocalDateTime createDate, Account[] accounts) {
		this.id = id;
		this.name =name;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
}

package com.vti.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "DepartmentName", length = 50, nullable = false, unique = true)
	private String name;

//	@ManyToOne
//	@JoinColumn(name = "AccountID")         //Sql attribute, tạo kết nối vật lý
//	private Account account;

	public Department() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
}

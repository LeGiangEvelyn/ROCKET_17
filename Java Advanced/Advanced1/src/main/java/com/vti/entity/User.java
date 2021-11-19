package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "`User`")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;

	// Must have
//	@OneToOne
//	@JoinColumn(name = "address_id", referencedColumnName = "id")
//	private Address address;

	//Many to many
	@ManyToMany
	@JoinTable(
			name = "UserAddress",	// table trung gian
			joinColumns = { @JoinColumn(name="user_id") },				//sql name
			inverseJoinColumns = { @JoinColumn(name="address_id") }		//sql
	)
	private List<Address> addresses;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}


}

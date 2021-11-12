package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String group;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp 			//Set default date, only timestamp
	private Date createDate;

	public Group() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Group { " + "ID = " + id + ", Name = '" + group + '\'' + '}';
	}

}

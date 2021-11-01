package com.vti.filtter;

import java.util.Date;

public class DepartmentFilter {
	private Integer minTotalMember;
	private Integer maxTotalMember;
	
	private Date date;
	
	

	public DepartmentFilter() {
	}

	public Integer getMinTotalMember() {
		return minTotalMember;
	}

	public void setMinTotalMember(Integer minTotalMember) {
		this.minTotalMember = minTotalMember;
	}

	public Integer getMaxTotalMember() {
		return maxTotalMember;
	}

	public void setMaxTotalMember(Integer maxTotalMember) {
		this.maxTotalMember = maxTotalMember;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}

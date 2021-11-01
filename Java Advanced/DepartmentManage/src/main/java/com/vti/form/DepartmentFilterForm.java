package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DepartmentFilterForm {

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxDate;
	
	private Integer minYear;
	private Integer maxYear;

	public DepartmentFilterForm() {
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public Integer getMinYear() {
		return minYear;
	}

	public void setMinYear(Integer year) {
		this.minYear = year;
	}

	public Integer getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(Integer maxYear) {
		this.maxYear = maxYear;
	}

}

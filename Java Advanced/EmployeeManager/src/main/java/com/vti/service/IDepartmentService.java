package com.vti.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(int pageNumber, int pageSize, Pageable pageable);

	public Department getDepartmentByID(int id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(int id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(int id);

	public boolean isDepartmentExistsByID(int id);

	public boolean isDepartmentExistsByName(String name);

}

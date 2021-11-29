package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")		//nhung api theo dung restful api
//@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;				//khoi tao service

	@GetMapping()
	public Page<Department> getAllDepartments(int pageNumber, int pageSize, Pageable pageable) {
		return new ResponseEntity<>(service.getAllDepartments(pageNumber, pageSize, pageable), HttpStatus.OK); 
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") int id) {
		return service.getDepartmentByID(id);
	}

	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}

	@PutMapping(value = "/{id}")		//= mapping Controller + {id}
	//@RequestBody: truyen data nhay cam can bao mat vao Body
	//@Pathvariable: cho vao value id
	public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department) {
		department.setId(id);
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") int id) {
		service.deleteDepartment(id);
	}
}

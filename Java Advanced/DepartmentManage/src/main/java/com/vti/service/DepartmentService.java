package com.vti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.DepartmentSpecification;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IAccountRepository accountRepository;

	@SuppressWarnings("deprecation")
	public Page<Department> getAllDepartments(Pageable paging, String search, DepartmentFilterForm departmentFilter) throws ParseException {
		Specification<Department> where = null;

		if (!StringUtils.isEmpty(search)) {
			DepartmentSpecification nameSpecification = new DepartmentSpecification("name", "LIKE", search);
			DepartmentSpecification addressSpecification = new DepartmentSpecification("address.addressName", "LIKE",
					search);
			where = Specification.where(nameSpecification).or(addressSpecification);
		}
		if (!StringUtils.isEmpty(search)) {
			DepartmentSpecification nameSpecification = new DepartmentSpecification("name", "LIKE", search);
			DepartmentSpecification authorSpecification = new DepartmentSpecification("author.fullName", "LIKE",
					search);
			where = Specification.where(nameSpecification).or(authorSpecification);
		}
		
		if(departmentFilter != null && departmentFilter.getMinYear() != null) {
			
			Date minDate = new SimpleDateFormat("yyyy/MM/dd").parse(departmentFilter.getMinYear() + "/01/01");
			DepartmentSpecification minDateSpecification = new DepartmentSpecification("createDate", ">=", minDate);
			if(where == null) {
				where = Specification.where(minDateSpecification);
			} else {
				where  = where.and(minDateSpecification);
			}
			}

		if(departmentFilter != null && departmentFilter.getMinDate() != null) {
			DepartmentSpecification minDateSpecification = new DepartmentSpecification("createDate", ">=", departmentFilter.getMinDate());
			if(where == null) {
				where = Specification.where(minDateSpecification);
			} else {
				where  = where.and(minDateSpecification);
			}
		}
		
		if(departmentFilter != null && departmentFilter.getMaxYear() != null) {
			
			Date maxDate = new SimpleDateFormat("yyyy/MM/dd").parse((departmentFilter.getMaxYear()+1) + "/01/01");
			DepartmentSpecification maxDateSpecification = new DepartmentSpecification("createDate", "<=", maxDate);
			if(where == null) {
				where = Specification.where(maxDateSpecification);
			} else {
				where  = where.and(maxDateSpecification);
			}
			}
		if(departmentFilter != null && departmentFilter.getMaxDate() != null) {
			DepartmentSpecification maxDateSpecification = new DepartmentSpecification("createDate", "<=", departmentFilter.getMaxDate());
			if(where == null) {
				where = Specification.where(maxDateSpecification);
			} else {
				where  = where.and(maxDateSpecification);
			}
		}

		return departmentRepository.findAll(where, paging);
	}

	public Department getDepartmentByID(short id) {
		return departmentRepository.findById(id).get();
	}

	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	public void createDepartment(DepartmentFormForCreating form) {
		// convert form --> entity

		// get author by id
		Account author = accountRepository.findById(form.getAuthorId()).get();

		Department department = new Department(form.getName());
		department.setAuthor(author);

		departmentRepository.save(department);
	}

	public void updateDepartment(short id, DepartmentFormForUpdating form) {
		Department department = getDepartmentByID(id);
		department.setName(form.getName());

		departmentRepository.save(department);
	}

	public void deleteDepartment(short id) {
		departmentRepository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return departmentRepository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return departmentRepository.existsByName(name);
	}
	
	public void deleteDepartments(List<Short> ids) {
		departmentRepository.deleteByIds(ids);
	}

}

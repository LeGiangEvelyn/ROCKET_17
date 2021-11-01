package com.vti.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short>, JpaSpecificationExecutor<Department> {

	public Department findByName(String name);

	public boolean existsByName(String name);
	
	//Department: java name, Modifying for Query
	@Modifying
	@Transactional
	@Query("DELETE FROM Department WHERE id IN(:ids)")
	public void deleteByIds(@Param("ids") List<Short> ids);
	
	
}

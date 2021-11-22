package com.vti.repository;

import com.vti.entity.DTO.DepartmentDto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.Scanner;


public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentDto> getAllDepartments(int pageNumber, int pageSize, String searchName, short emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query: need to clarify locate link, if not then unable to locate
			Query query = session.createQuery("SELECT new com.vti.entity.DTO.DepartmentDto(dt.id, d.name, a.name)" +
						" FROM com.vti.entity.DetailDepartment dt " +
						"JOIN com.vti.entity.Address a ON dt.address = a.id " +
						"JOIN com.vti.entity.Department d ON dt.id = d.id " +
						"WHERE d.name LIKE :searchName AND dt.emulationPoint > :point " +
						"ORDER BY d.name");

			int offset = (pageNumber - 1) * pageSize;
			int limit = pageSize;

			query.setFirstResult(offset);
			query.setMaxResults(limit);
			query.setParameter("searchName", searchName);
			query.setParameter("point", emulationPoint);

			List<DepartmentDto> departments = query.list();

			return departments;



		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public Department getDepartmentByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(department);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);


		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}

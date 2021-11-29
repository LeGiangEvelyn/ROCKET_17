package com.vti.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

	private HibernateUtils hibernateUtils;
//	private final CriteriaBuilder criteriaBuilder;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Page<Department> getAllDepartments(int pageNumber, int pageSize, Pageable pageable) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			
			//create Criteria
			
			Criteria criteria = session.createCriteria(Department.class);
			
			criteria.addOrder(Order.asc("id"));
			int offset = (pageNumber - 1) * pageSize;
			int limit = pageSize;
			criteria.setFirstResult(offset);
			criteria.setMaxResults(limit);
			
			Sort sort = Sort.by(Sort.Direction.ASC, "name");
			pageable = PageRequest.of(0,pageSize, sort);
//			criteria.add(Restrictions.ilike("name", "%" + searchName.toLowerCase() + "%"));
						
			return  new PageImpl<>(criteria.list(), pageable, count);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	private Pageable getPageable() {
        
        return PageRequest.of(,employeePage.getPageSize(), sort);
    }


	public Department getDepartmentByID(int id) {

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
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(int id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

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

	public void deleteDepartment(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(int id) {

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

package com.vti.repository;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {
    private HibernateUtils hibernateUtils;

    public EmployeeRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        Session session = null;

        try {
            //get session
            session = hibernateUtils.openSession();

            //create hql
            Query<Employee> query = session.createQuery("FROM Employee");

            return  query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createEmployee(Employee employee) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(employee);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

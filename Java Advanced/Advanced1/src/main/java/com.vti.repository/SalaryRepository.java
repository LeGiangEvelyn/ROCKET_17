package com.vti.repository;

import java.util.List;

import com.vti.entity.Salary;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {

    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalaries() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Salary> query = session.createQuery("FROM Salary");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createSalary(Salary salary) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(salary);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

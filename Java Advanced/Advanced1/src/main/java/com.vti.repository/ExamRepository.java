package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ExamRepository {
    private HibernateUtils hibernateUtils;

    public ExamRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createExam(Exam exam){

        Session session = null;

        try {
            //get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            //create
            session.save(exam);
            session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public int getCountByCode(char codeType) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            //create hql
            Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE code1 LIKE :codeType");
            //set parameter
            query.setParameter("codeType", codeType);
            //get Result
            return query.uniqueResult().intValue();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }
}

package com.vti.entity.generate;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class ExamCodeGenerator implements IdentifierGenerator {

    private ExamRepository repository;

    public ExamCodeGenerator() {
        repository = new ExamRepository();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        Exam exam = (Exam) object;

        short duration = exam.getDuration();
        int count = repository.getCountByCode(duration);
        if (duration >= 180) {
            return "L - " + (count + 1);
        }
        if (duration >= 90) {
            return "M - " + (count + 1);
        }
        else {
            return "S - " + (count+1);
    }
}
}

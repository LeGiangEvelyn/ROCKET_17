package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Salary`")
public class Salary implements Serializable {

    private static final long serializableUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryConverter.class)
    private SalaryName name;

    public Salary() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public SalaryName getName() {
        return name;
    }

    public void setName(SalaryName name) {
        this.name = name;
    }
}

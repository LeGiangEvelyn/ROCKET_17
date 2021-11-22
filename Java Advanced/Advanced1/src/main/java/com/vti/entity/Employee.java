package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Employee`")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingYear;

    public Employee() {
    }

    public short getWorkingYear() {
        return workingYear;
    }

    public void setWorkingYear(short workingYear) {
        this.workingYear = workingYear;
    }
}

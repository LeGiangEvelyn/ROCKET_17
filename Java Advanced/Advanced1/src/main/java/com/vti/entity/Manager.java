package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Manager`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Manager extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short mangeYear;
}

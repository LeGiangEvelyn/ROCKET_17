package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`Account`", catalog = "TestingSystem")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;

    @Formula(" concat(FirstName, ' ', LastName) ")
    private String fullName;


    @OneToMany(mappedBy = "account")    //bien account bên Department vừa tạo của @ManyToOne
    private List<Department> departmentList;


    @OneToMany(mappedBy = "account")    //bien account bên Position vừa tạo của @ManyToOne
    private List<Position> positionList;


    @OneToMany(mappedBy = "account")    //bien account bên Salary vừa tạo của @ManyToOne
    private List<Salary> salaryList;

    @ManyToMany
    @JoinTable(
            name = "GroupAccount",       //table trung gian
            joinColumns = { @JoinColumn(name = "AccountID")},
            inverseJoinColumns = { @JoinColumn(name = "GroupID")}
    )
    private List<Group> groupList;

    @OneToOne(mappedBy = "creator")
    private Question question;

    @OneToMany(mappedBy = "creator")
    private List<Exam> examList;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    public Account() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "Account [id=" + id + ", email=" + email + ", username=" + username + ", firstName=" + firstName
                + ", lastName=" + lastName + ", fullName=" + fullName + ", createDate=" + createDate + "]";
    }
}

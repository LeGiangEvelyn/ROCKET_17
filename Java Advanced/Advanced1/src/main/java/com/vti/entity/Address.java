package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Address", catalog = "TestingSystem")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", length = 100, nullable = false, unique = true)
    private String street;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    //Co the bo duoc
    // mappedBy bang bien java address sang bang User
    // Khi lay ra address se cho ra cac user
    //@OneToOne(mappedBy = "address")

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
    @Table(name = "DetailDepartment", catalog = "TestingSystem")
    @PrimaryKeyJoinColumn(name = "DepartmentID")
    public class DetailDepartment extends Department implements Serializable {

        @Id
        @Column(name = "DepartmentID")
        @GeneratedValue
        private Short id;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
        private Address address;


        @Column(name = "EmulationPoint")
        private Short emulationPoint;

        public DetailDepartment() {
        }

        public short getId() {
            return id;
        }

        public void setId(Short id) {
            this.id = id;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Short getEmulationPoint() {
            return emulationPoint;
        }

        public void setEmulationPoint(Short emulationPoint) {
            this.emulationPoint = emulationPoint;
        }

        @Override
        public String toString() {
            return "DetailDepartment{" +
                    "id=" + id +
                    ", address=" + address +
                    ", emulationPoint=" + emulationPoint +
                    '}';
        }
    }

package com.vti.entity;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Person {
    private String name;
    private Gender gender;
    private LocalDate dateBirth;
    private String address;

    public Person(){
        super();
    }
    public Person(String name, Gender gender, LocalDate dateBirth, String address) {
        super();
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        this.name = sc.nextLine();
        System.out.println("Gender: 1.Male 2.Female 3.Unknown");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                this.gender = Gender.MALE;
                break;
            case 2:
                this.gender = Gender.FEMALE;
                break;
            case 3:
                this.gender = Gender.UNKNOWN;
                break;
        }
        System.out.println("Enter date of birth: (yyyy-mm-dd) ");
        this.dateBirth = LocalDate.parse(sc.nextLine());
        System.out.println("Enter address: ");
        this.address = sc.nextLine();
    }

    public String showInfor(){
        return ("Person: Name: " + name + "%n/" +
                "Gender: " + gender + "%n/+" +
                "Date of birth: " + dateBirth + "%n/"+
                "Address: " + address + "%n/");
    }

    protected void inputInfo() {
    }
}

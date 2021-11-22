package com.vti.entity;

import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.PositionNameConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position implements Serializable {

    private static final long serializableUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)           //Khai bao ham converter
    //@Enumerated(EnumType.STRING) //Using position.setQuestion(PositionName.DEV)
    private PositionName name;

    @ManyToOne
    @JoinColumn(name = "AccountID")         //Sql attribute, tạo kết nối vật lý
    private Account account;

    public Position() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

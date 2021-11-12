package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "TypeName", nullable = false, unique = true)
    private String type;

    public TypeQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}

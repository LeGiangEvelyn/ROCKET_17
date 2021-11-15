package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable {

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "CategoryName", nullable = false, unique = true)
    private String category;

    public CategoryQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getType() {
        return category;
    }

    public void setCategory(String type) {
        this.category = type;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", type='" + category + '\'' +
                '}';
    }
}

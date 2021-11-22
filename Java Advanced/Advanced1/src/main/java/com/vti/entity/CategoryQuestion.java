package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable {

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "CategoryName", nullable = false, unique = true)
    private String category;

//    @OneToMany(mappedBy = "categoryQuestions")
//    private Question question;

    @OneToMany(mappedBy = "categoryQuestion")
    private List<Exam> examList;

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

    public String getCategory() {
        return category;
    }

//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
}

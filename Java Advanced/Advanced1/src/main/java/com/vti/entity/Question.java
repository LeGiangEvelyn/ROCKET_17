package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "QuestionName", length = 100, nullable = false, unique = true)
    private String question;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp 			//Set default date, only timestamp
    private Date createDate;

    public Question() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "Group { " + "ID = " + id + ", Name = '" + question + '\'' + '}';
    }

}

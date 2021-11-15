package com.vti.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @Column(name = "isCorrect", updatable = false)
    @ColumnDefault("1")
    private Boolean isCorrect;

    public Answer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }



    @Override
    public String toString() {
        return "Answer { " + "ID = " + id + ", Content = '" + content + '\'' + '}';
    }

}

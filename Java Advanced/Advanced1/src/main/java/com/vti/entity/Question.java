package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

//    @ManyToOne
//    @JoinColumn(name = "CategoryID")
//    private List<CategoryQuestion> categoryQuestions;

//    @ManyToOne
//    @JoinColumn(name = "TypeID")
//    private List<TypeQuestion> typeQuestions;

//    @OneToOne
//    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID")
//    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp 			//Set default date, only timestamp
    private Date createDate;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

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

//
//    public List<CategoryQuestion> getCategoryQuestions() {
//        return categoryQuestions;
//    }

//    public void setCategoryQuestions(List<CategoryQuestion> categoryQuestions) {
//        this.categoryQuestions = categoryQuestions;
//    }
//
//    public List<TypeQuestion> getTypeQuestions() {
//        return typeQuestions;
//    }
//
//    public void setTypeQuestions(List<TypeQuestion> typeQuestions) {
//        this.typeQuestions = typeQuestions;
//    }

//    public Account getCreator() {
//        return creator;
//    }
//
//    public void setCreator(Account creator) {
//        this.creator = creator;
//    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}

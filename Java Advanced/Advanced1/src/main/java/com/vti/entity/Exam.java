package com.vti.entity;

import com.vti.entity.enumerate.ExamType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Code1", length = 10, nullable = false, updatable = false)
    @GenericGenerator(
            name = "exam-code-generator",
            strategy = "com/vti/entity/generate/ExamCodeGenerator"
    )
    @GeneratedValue(generator = "exam-code-generator")
    private String code1;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Duration")
    @ColumnDefault("45")
    private short duration;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Exam() {
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", code1='" + code1 + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", createDate=" + createDate +
                '}';
    }
}

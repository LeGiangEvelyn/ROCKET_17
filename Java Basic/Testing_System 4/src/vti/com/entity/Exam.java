package vti.com.entity;

import java.time.LocalDateTime;

public class Exam {
	private int id;
	private String code;
	private String title;
	private CategoryQuestion category;
	private int duration;
	private Account creator;
	private LocalDateTime createDate;
	private Question[] questions;
	
	public Exam() {
		
	}
	public Exam(int id, String code, String title, CategoryQuestion category, int duration, Account creator, LocalDateTime createDate, Question[] questions) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.category = category;
		this.duration = duration;
		this.creator = creator;
		this.createDate = createDate;
		this.questions = questions;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CategoryQuestion getCategory() {
		return category;
	}
	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
}

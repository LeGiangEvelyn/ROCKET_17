package vti.com.entity;

public class Answer {
	private int id;
	private String content;
	private Question question;
	private Boolean isCorrect;
	
	public Answer() {
		
	}
	public Answer(int id, String content, Question question, Boolean isCorrect) {
		this.id = id;
		this.content = content;
		this.question = question;
		this.isCorrect = isCorrect;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}

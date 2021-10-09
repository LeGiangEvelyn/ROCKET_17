package vti.com.entity;

import java.time.LocalDateTime;

public class Question {
	int id;
	String content;
	CategoryQuestion categoryQuestion;
	TypeQuestion typeQuestion;
	Account creator;
	LocalDateTime createDate;
}

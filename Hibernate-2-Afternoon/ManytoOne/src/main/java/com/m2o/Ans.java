package com.m2o;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Ans{
	
	@Id
	@Column(name="answer_id")
	private int answerid;
	
	private String answer;
	
	@ManyToOne
	private Ques question;

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Ques getQuestion() {
		return question;
	}

	public void setQuestion(Ques question) {
		this.question = question;
	}

	public Ans(int answerid, String answer, Ques question) {
		super();
		this.answerid = answerid;
		this.answer = answer;
		this.question = question;
	}

	public Ans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

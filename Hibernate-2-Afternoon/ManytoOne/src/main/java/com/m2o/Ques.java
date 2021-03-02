package com.m2o;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Ques {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	
	private String question;
	
	@OneToMany(mappedBy = "question")
	private List<Ans> answers;


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<Ans> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Ans> answers) {
		this.answers = answers;
	}


	public Ques(int questionId, String question, List<Ans> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}


	public Ques() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}

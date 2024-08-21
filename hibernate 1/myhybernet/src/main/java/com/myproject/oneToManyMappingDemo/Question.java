package com.myproject.oneToManyMappingDemo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "question_1")
public class Question {
	
	@Id
	private int qid;
	
	private String questionString ;
	
	
	//one to many relationship one question many answer
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", questionString=" + questionString + ", answers=" + answers + "]";
	}
	
	
}

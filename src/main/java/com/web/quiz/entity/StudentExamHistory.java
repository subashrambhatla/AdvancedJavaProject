package com.web.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "StudentExamHistory")
public class StudentExamHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examHistoryId;

	private String userselectedanswer;

	private String correctanswer;

	private Integer questionId;

	private Integer userID;

	public Integer getExamHistoryId() {
		return examHistoryId;
	}

	public void setExamHistoryId(Integer examHistoryId) {
		this.examHistoryId = examHistoryId;
	}

	public String getUserselectedanswer() {
		return userselectedanswer;
	}

	public void setUserselectedanswer(String userselectedanswer) {
		this.userselectedanswer = userselectedanswer;
	}

	public String getCorrectanswer() {
		return correctanswer;
	}

	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "StudentExamHistory [userselectedanswer=" + userselectedanswer + ", correctanswer=" + correctanswer
				+ ", questionId=" + questionId + ", userID=" + userID + "]";
	}

}

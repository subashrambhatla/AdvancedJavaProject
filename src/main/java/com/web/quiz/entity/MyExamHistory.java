package com.web.quiz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyExamHistory")
public class MyExamHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer myExamHistoryId;

	private Integer examresult;

	private Integer totalQuestions;

	private Date createdOn;

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMyExamHistoryId() {
		return myExamHistoryId;
	}

	public void setMyExamHistoryId(Integer myExamHistoryId) {
		this.myExamHistoryId = myExamHistoryId;
	}

	public Integer getExamresult() {
		return examresult;
	}

	public void setExamresult(Integer examresult) {
		this.examresult = examresult;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}

package com.web.quiz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examId;

	@Column
	private String questionTitle;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examId", referencedColumnName = "examId")
	private Set<ExamOptions> myoptions;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Set<ExamOptions> getMyoptions() {
		return myoptions;
	}

	public void setMyoptions(Set<ExamOptions> myoptions) {
		this.myoptions = myoptions;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", questionTitle=" + questionTitle + ", myoptions=" + myoptions + "]";
	}

	

}
package com.web.quiz.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.quiz.entity.Exam;

public interface ExamRepositry extends JpaRepository<Exam, String> {

	
	
	
}

package com.web.quiz.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.quiz.entity.StudentExamHistory;

public interface ExamHistoryRepositry extends JpaRepository<StudentExamHistory, String> {

	@Query("SELECT u FROM com.web.quiz.entity.StudentExamHistory u WHERE u.userID = userID")
	List<StudentExamHistory> getExamResult(Integer userID);
}

package com.web.quiz.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.quiz.entity.MyExamHistory;

public interface MyExamHistoryRepositry extends JpaRepository<MyExamHistory, String> {

	
	@Query("SELECT u FROM com.web.quiz.entity.MyExamHistory u WHERE u.userId = userId")
	List<MyExamHistory> getExamHistroyById(Integer userId);

}

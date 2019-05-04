package com.web.quiz.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.quiz.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, String> {

	@Query("select s from com.web.quiz.entity.Student s where s.rollNo= :rollNo")
	public Student getstudentByRollNo(String rollNo);
	
}

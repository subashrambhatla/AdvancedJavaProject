package com.web.quiz.service;

import org.springframework.stereotype.Service;

import com.web.quiz.entity.Student;

@Service
public interface LoginService {

	public Student getstudentByRollNo(String rollNo);

	public Student saveStudent(Student student);

	public Student getSutdentData(String rollNo);
	
	
}

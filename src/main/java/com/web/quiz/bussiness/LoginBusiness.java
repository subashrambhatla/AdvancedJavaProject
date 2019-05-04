package com.web.quiz.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.quiz.entity.Student;
import com.web.quiz.service.LoginService;

@Component
public class LoginBusiness {

	@Autowired
	private LoginService loginService;

	public Student getstudentByRollNo(String rollNo) {
		Student student = loginService.getstudentByRollNo(rollNo);
		return student;
		
		
	}

	public Student saveStudent(Student student) {
		student.setRole("student");
		return loginService.saveStudent(student);

	}

	public Student getSutdentData(String rollNo) {
		return loginService.getSutdentData(rollNo);
	}

}

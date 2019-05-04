package com.web.quiz.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.quiz.entity.Student;
import com.web.quiz.repositry.StudentRepositry;
import com.web.quiz.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private StudentRepositry studentRepositry;

	@Override
	public Student getstudentByRollNo(String rollNo) {
		return studentRepositry.getstudentByRollNo(rollNo);

	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepositry.save(student);
	}

	@Override
	public Student getSutdentData(String rollNo) {
		Optional<Student> stu = studentRepositry.findById(rollNo);

		if (stu.isPresent()) {
			return stu.get();
		}
		return  null;
	}

}

package com.web.quiz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.web.quiz.bussiness.LoginBusiness;
import com.web.quiz.entity.Student;

@RestController
public class LoginController {

	@Autowired
	private LoginBusiness loginBusiness;

	@Autowired
	private HttpSession httpSession;

	private String globalId;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@PostMapping("/checkStudent")
	public Student checkStudent(@RequestBody Student student) {
		Integer rollNo = Integer.parseInt(student.getRollNo());
		httpSession.setAttribute("rollNo", rollNo);
		globalId = student.getRollNo();
		return loginBusiness.getstudentByRollNo(student.getRollNo());
	}

	@GetMapping("/myProfile")
	public ModelAndView editprofile() {
		return new ModelAndView("editprofile");
	}

	@PostMapping("/getSutdentData")
	public Student getSutdentData(@RequestBody Student student) {
		Integer rollNo = (Integer) httpSession.getAttribute("rollNo");
		return loginBusiness.getSutdentData(Integer.toString(rollNo));
	}

	@GetMapping("/registration")
	public ModelAndView studentRegistration() {
		ModelAndView andView = new ModelAndView("registration");
		return andView;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("index");
		
		Student student = loginBusiness.getstudentByRollNo(globalId);
		andView.addObject("student", student);
		return andView;	}

	@PostMapping("/saveStudent")
	public Student studentRegistration(@RequestBody Student student) {
		return loginBusiness.saveStudent(student);
	}
}

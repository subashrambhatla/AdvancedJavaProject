package com.web.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.web.quiz.bussiness.ExamBussiness;
import com.web.quiz.entity.Exam;
import com.web.quiz.entity.ExamDetails;
import com.web.quiz.entity.MyExamHistory;

@RestController
public class StudentExamController {
	@Autowired
	private ExamBussiness examBussiness;
	@Autowired
	HttpSession httpsession;

	@GetMapping("/startExam")
	public ModelAndView getAllExams() {
		return new ModelAndView("startExam");
	}

	@GetMapping("/getQuestionByID/{id}")
	public ModelAndView getById(@PathVariable Integer id) {

		httpsession.setAttribute("id", id);
		return new ModelAndView("editcreateExam");
	}

	@GetMapping("/deleteQuestion/{id}")
	public ModelAndView deleteQuestion(@PathVariable Integer id) {
		examBussiness.deleteQuestion(id);
		return new ModelAndView("updatequestions");
	}

	@PostMapping("getQuestionByID/getExamById1")
	public Exam getExamById() {
		Integer examId = (Integer) httpsession.getAttribute("id");
		return examBussiness.getQuestionByID(examId);

	}

	

	@GetMapping("/updatequestions")
	public ModelAndView updatequestions() {
		return new ModelAndView("updatequestions");
	}

	@PostMapping("/getAllQuestions")
	public List<ExamDetails> getAllQuestionsofExam() {

		return examBussiness.getAllQuestions();

	}

	@GetMapping("/createExam")
	public ModelAndView createExam() {
		return new ModelAndView("createExam");
	}

	@PostMapping("/saveStudentExam")
	public ModelAndView saveStudentExam(@RequestBody ExamDetails exam) {
		examBussiness.studentExamsave(exam);
		return new ModelAndView("createExam");
	}

	@PostMapping("/getQuestions/{qid}/{ans}")
	public Exam getExam(@PathVariable Integer qid, @PathVariable String ans) {
		Integer userId = (Integer) httpsession.getAttribute("rollNo");
		Exam e = examBussiness.loadExam(qid, ans, userId);
		return e;

	}

	@GetMapping("/examSubmit")
	public ModelAndView examSubmit() {
		Integer userId = (Integer) httpsession.getAttribute("rollNo");
		ModelAndView andView = null;
		if (userId != null) {

			Integer result = examBussiness.examSubmit(userId);
			Integer totalquestions = examBussiness.gettotlaquestons(userId, result);
			andView = new ModelAndView("examScorePage");
			andView.addObject("result", result);
			andView.addObject("totalquestions", totalquestions);
			andView.addObject("getpecentage", examBussiness.getpercentage(result, totalquestions));
		} else {
			andView = new ModelAndView("home");
		}
		return andView;

	}

	@GetMapping("/examHistory")
	public ModelAndView examHistory() {
		Integer userId = (Integer) httpsession.getAttribute("rollNo");
		ModelAndView andView = null;
		if (userId == null) {
			andView = new ModelAndView("home");
		} else {
			andView = new ModelAndView("examHistory");

		}
		return andView;

	}

	@PostMapping("/getExamHistroy")
	public List<MyExamHistory> getExamHistroy() {
		Integer userId = (Integer) httpsession.getAttribute("rollNo");
		return examBussiness.getExamHistroy(userId);

	}

}

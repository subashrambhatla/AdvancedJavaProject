package com.web.quiz.bussiness;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.quiz.entity.Exam;
import com.web.quiz.entity.ExamDetails;
import com.web.quiz.entity.ExamOptions;
import com.web.quiz.entity.MyExamHistory;
import com.web.quiz.entity.StudentExamHistory;
import com.web.quiz.service.ExamService;

@Component
public class ExamBussiness {

	@Autowired
	private ExamService examService;

	private int index;

	public Exam studentExamsave(ExamDetails exam) {

		Exam exam2 = new Exam();
		ExamOptions examOptions = new ExamOptions();
		Set<ExamOptions> myoptions = new HashSet<ExamOptions>();
		exam2.setQuestionTitle(exam.getQuestionTitle());
		examOptions.setOption1(exam.getOption1());
		examOptions.setOption2(exam.getOption2());
		examOptions.setOption3(exam.getOption3());
		examOptions.setOption4(exam.getOption4());
		examOptions.setCorrectAnswer(exam.getCorrectAnswer());
		myoptions.add(examOptions);
		exam2.setMyoptions(myoptions);

		if (exam.getExamId() != null) {
			exam2.setExamId(exam.getExamId());
		}

		return examService.savestudentExam(exam2);
	}

	public List<Exam> getAllQuestionList() {
		return examService.getAllQuestionList();
	}

	public Exam loadExam(Integer qid, String ans, Integer userId) {
		List<Exam> examList = examService.getAllQuestionList();

		if (ans.equals("0") || qid == 0) {
			index = 0;
			return examList.get(0);
		} else {
			try {
				saveExamHistory(qid, ans, userId, examList.get(index));
				index = index + 1;
				return examList.get(index);
			} catch (Exception e) {
				return null;
			}
		}

	}

	public void saveExamHistory(Integer qid, String userselectedans, Integer userId, Exam exam) {
		StudentExamHistory ex = new StudentExamHistory();
		String correctanswer = "";
		Set<ExamOptions> myoptions = exam.getMyoptions();
		for (ExamOptions examOptions : myoptions) {
			correctanswer = examOptions.getCorrectAnswer();
		}
		ex.setCorrectanswer(correctanswer);
		ex.setQuestionId(qid);
		ex.setUserID(userId);
		ex.setUserselectedanswer(userselectedans);
		examService.saveExamHistory(ex);
	}

	public Integer examSubmit(Integer rollNo) {
		List<StudentExamHistory> list = examService.examSubmit(rollNo);
		Integer result = 0;
		for (StudentExamHistory studentExamHistory : list) {
			if (studentExamHistory.getCorrectanswer().equals(studentExamHistory.getUserselectedanswer())) {
				result++;
			}
		}
		return result;
	}

	public Integer gettotlaquestons(Integer userId, Integer result) {
		List<StudentExamHistory> list = examService.examSubmit(userId);
		Integer count = list.size();

		MyExamHistory examHistory = new MyExamHistory();
		examHistory.setCreatedOn(new Date());
		examHistory.setExamresult(result);
		examHistory.setTotalQuestions(count);
		examHistory.setUserId(userId);
		examService.saveMyExamHistory(examHistory);

		for (StudentExamHistory studentExamHistory : list) {
			examService.deleteStudentExamHistory(studentExamHistory);
		}

		return count;
	}

	public Integer getpercentage(Integer obtained, Integer total) {
		return obtained * 100 / total;

	}

	public List<MyExamHistory> getExamHistroy(Integer userId) {
		return examService.getExamHistroy(userId);
	}

	public List<ExamDetails> getAllQuestions() {
		List<Exam> exam = examService.getAllQuestionList();
		ExamDetails examdetails = new ExamDetails();
		ExamDetails examdetails2 = null;
		List<ExamDetails> details = new ArrayList<ExamDetails>();
		for (int i = 0; i < exam.size(); i++) {
			examdetails.setQuestionTitle(exam.get(i).getQuestionTitle());
			examdetails2 = getoptions(exam.get(i).getMyoptions());
			examdetails2.setQuestionTitle(examdetails.getQuestionTitle());
			examdetails2.setExamId(exam.get(i).getExamId());
			details.add(i, examdetails2);
		}
		return details;
	}

	public ExamDetails getoptions(Set<ExamOptions> setoption) {
		ExamDetails examdetails = new ExamDetails();

		for (ExamOptions setoptions : setoption) {
			examdetails.setOption1(setoptions.getOption1());
			examdetails.setOption2(setoptions.getOption2());
			examdetails.setOption3(setoptions.getOption3());
			examdetails.setOption4(setoptions.getOption4());
			examdetails.setCorrectAnswer(setoptions.getCorrectAnswer());
		}
		return examdetails;

	}

	public Exam getQuestionByID(Integer id) {
		return examService.getQuestionByID(id);
	}

	public void deleteQuestion(Integer id) {
		examService.deleteQuestion(id);
		
	}

}

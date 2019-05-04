package com.web.quiz.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.quiz.entity.Exam;
import com.web.quiz.entity.MyExamHistory;
import com.web.quiz.entity.StudentExamHistory;
import com.web.quiz.repositry.ExamHistoryRepositry;
import com.web.quiz.repositry.ExamRepositry;
import com.web.quiz.repositry.MyExamHistoryRepositry;
import com.web.quiz.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepositry examRepositry;

	@Autowired
	private ExamHistoryRepositry examHistoryRepositry;

	@Autowired
	private MyExamHistoryRepositry myExamHistoryRepositry;

	@Override
	public Exam savestudentExam(Exam exam) {

		return examRepositry.save(exam);
	}

	@Override
	public List<Exam> getAllQuestionList() {
		return examRepositry.findAll();
	}

	@Override
	public void saveExamHistory(StudentExamHistory ex) {
		examHistoryRepositry.save(ex);
	}

	@Override
	public List<StudentExamHistory> examSubmit(Integer rollNo) {

		return examHistoryRepositry.getExamResult(rollNo);
	}

	@Override
	public void saveMyExamHistory(MyExamHistory examHistory) {
		myExamHistoryRepositry.save(examHistory);
	}

	@Override
	public void deleteStudentExamHistory(StudentExamHistory studentExamHistory) {
		examHistoryRepositry.delete(studentExamHistory);
	}

	@Override
	public List<MyExamHistory> getExamHistroy(Integer userId) {
		return myExamHistoryRepositry.getExamHistroyById(userId);
	}

	@Override
	public Exam getQuestionByID(Integer id) {
		List<Exam> examlist = examRepositry.findAll();
		for (Exam exam : examlist) {
			if (exam.getExamId().equals(id)) {
				return exam;
			}
		}

		return null;

	}

	@Override
	public void deleteQuestion(Integer id) {
		List<Exam> examlist = examRepositry.findAll();
		for (Exam exam : examlist) {
			if (exam.getExamId().equals(id)) {
				examRepositry.delete(exam);
			}
		}
	}

}

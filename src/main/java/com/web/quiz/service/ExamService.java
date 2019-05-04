package com.web.quiz.service;

import java.util.List;

import com.web.quiz.entity.Exam;
import com.web.quiz.entity.MyExamHistory;
import com.web.quiz.entity.StudentExamHistory;

public interface ExamService {

	public Exam savestudentExam(Exam exam);

	public List<Exam> getAllQuestionList();

	public void saveExamHistory(StudentExamHistory ex);

	public List<StudentExamHistory> examSubmit(Integer rollNo);

	public void saveMyExamHistory(MyExamHistory examHistory);

	public void deleteStudentExamHistory(StudentExamHistory studentExamHistory);

	public List<MyExamHistory> getExamHistroy(Integer userId);

	public Exam getQuestionByID(Integer id);

	public void deleteQuestion(Integer id);

}

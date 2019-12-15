package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeService {
	public List<StudentGrade> getAllGradeByStudentID(int studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseName);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseName,int semester);
	public Integer save(StudentGrade studentGrade);	
	void update(StudentGrade updateGrade);
	void delete(int gradeID);
}

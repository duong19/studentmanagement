package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeService {
	public List<StudentGrade> getAllGradeByStudentID(String studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseID);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseID,int semester);
	public StudentGrade save(StudentGrade studentGrade);	
	void update(StudentGrade updateGrade);
	void delete(int gradeID);
	List<StudentGrade> getAllGradeBySemester(int semester);
}

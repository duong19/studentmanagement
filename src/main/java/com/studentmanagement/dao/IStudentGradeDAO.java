package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeDAO {
	public List<StudentGrade> getAllGradeByStudentID(int studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseName);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseName,int semester);
	public Integer save(StudentGrade studentGrade);
	public void update(StudentGrade updateGrade);
	public void deleteStudentGrade(int gradeID);
	StudentGrade findOne(int gradeID);
	
}

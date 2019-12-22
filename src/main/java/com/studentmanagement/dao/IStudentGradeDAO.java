package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeDAO {
	public List<StudentGrade> getAllGradeByStudentID(String studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseID);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseID,int semester);
	public StudentGrade save(StudentGrade studentGrade);
	public void update(StudentGrade updateGrade);
	public void deleteStudentGrade(int gradeID);
	StudentGrade findOne(int gradeID);
	List<StudentGrade> getAllGradeBySemester(int semester);
	
}

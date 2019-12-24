package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.model.Semester;
import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeDAO {
	public List<StudentGrade> getAllGradeByStudentID(String studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseID);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseID,String semester);
	public StudentGrade save(StudentGrade studentGrade);
	public boolean update(StudentGrade updateGrade);
	public boolean deleteStudentGrade(int gradeID);
	StudentGrade findOne(int gradeID);
	List<StudentGrade> getAllGradeBySemester(String semester);
	List<Semester> getAllSemester();
	
}

package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.model.Semester;
import com.studentmanagement.model.StudentGrade;

public interface IStudentGradeService {
	public List<StudentGrade> getAllGradeByStudentID(String studentID);
	public List<StudentGrade> getAllGrade();
	public List<StudentGrade> getAllGradeByCourse(String courseID);
	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseID,String semester);
	public StudentGrade save(StudentGrade studentGrade);	
	StudentGrade update(StudentGrade updateGrade);
	void delete(int gradeID);
	List<StudentGrade> getAllGradeBySemester(String semester);
	List<Semester> getAllSemester();
}

package com.studentmanagement.dao.imp;

import java.util.List;

import com.studentmanagement.dao.IStudentGradeDAO;
import com.studentmanagement.mapper.StudentGradeMapper;
import com.studentmanagement.model.StudentGrade;

public class StudentGradeDAO extends AbstractDAO implements IStudentGradeDAO {

	public List<StudentGrade> getAllGradeByStudentID(int studentID) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c, semester s\r\n"
												+ " where sg.studentID = " + studentID
												+ " and sg.courseID = c.courseID\r\n"
												+ "and sg.semesterID = s.semesterID");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGrade() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c, semester s\r\n"
				+ "where sg.courseID = c.courseID\r\n"
				+ "and sg.semesterID = s.semesterID");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGradeByCourse(String courseName) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c, semester s\r\n"
				+ " where c.courseName = '" + courseName + "'\r\n" 
				+ " and sg.courseID = c.courseID\r\n"
				+ "and sg.semesterID = s.semesterID");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseName, int semester) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c, semester s\r\n"
				+ " where c.courseName = '" + courseName + "'\r\n"
				+ "and s.semester =" + semester + "\r\n" 
				+ " and sg.courseID = c.courseID\r\n"
				+ "and sg.semesterID = s.semesterID");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

}

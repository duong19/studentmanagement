package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.StudentGrade;

public class StudentGradeMapper implements RowMapper<StudentGrade>{

	public StudentGrade mapRow(ResultSet resultSet) {
		try {
			StudentGrade grade = new StudentGrade();
			grade.setCourseID(resultSet.getString("courseID"));
			grade.setCourseName(resultSet.getString("courseName"));
			grade.setCredit(resultSet.getFloat("courseCredit"));
			grade.setGrade1(resultSet.getFloat("grade1"));
			grade.setGrade2(resultSet.getFloat("grade2"));
			grade.setSemester(resultSet.getInt("semester"));
			grade.setStudentID(resultSet.getInt("studentID"));
			grade.setGradeID(resultSet.getInt("gradeID"));
			grade.setMidCredit(resultSet.getFloat("midTermCredit"));
			grade.setEndCredit(resultSet.getFloat("endTermCredit"));
			return grade;
		}catch(SQLException e) {
			return null;
		}
	}
	
}

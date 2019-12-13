package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.StudentGrade;

public class StudentGradeMapper implements RowMapper<StudentGrade>{

	public StudentGrade mapRow(ResultSet resultSet) {
		try {
			StudentGrade grade = new StudentGrade();
			grade.setCourseID(resultSet.getInt("courseID"));
			grade.setCourseName(resultSet.getString("courseName"));
			grade.setCredit(resultSet.getFloat("courseCredit"));
			grade.setGrade(resultSet.getFloat("grade"));
			grade.setSemester(resultSet.getInt("semester"));
			grade.setStudentID(resultSet.getInt("studentID"));
			grade.setGradeID(resultSet.getInt("gradeID"));
			return grade;
		}catch(SQLException e) {
			return null;
		}
	}
	
}

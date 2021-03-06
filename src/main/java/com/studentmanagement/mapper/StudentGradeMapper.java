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
			grade.setCredit(resultSet.getInt("courseCredit"));
			grade.setGrade1(resultSet.getFloat("grade1"));
			grade.setGrade2(resultSet.getFloat("grade2"));
			grade.setSemester(resultSet.getString("semester"));
			grade.setStudentID(resultSet.getString("studentID"));
			grade.setGradeID(resultSet.getInt("gradeID"));
			grade.setMidCredit(resultSet.getFloat("midTermCredit"));
			grade.setEndCredit(resultSet.getFloat("endTermCredit"));
			grade.setName(resultSet.getString("student_name"));
			grade.setMessage("success");
			return grade;
		}catch(SQLException e) {
			return null;
		}
	}
	
}

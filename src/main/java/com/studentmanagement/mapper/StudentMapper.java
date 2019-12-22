package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet) {
		try {
			Student student = new Student();
			student.setAddress(resultSet.getString("address"));
			student.setBirthday(resultSet.getString("birthday"));
			student.setName(resultSet.getString("student_name"));
			student.setStudentID(resultSet.getString("studentID"));
			student.setPassword(resultSet.getString("password"));
			student.setRoleID(resultSet.getInt("roleID"));
			student.setFaculty(resultSet.getString("faculty"));
			student.setMessage("success");

			return student;
		}catch(SQLException e) {
			return null;
		}
	}
	
}

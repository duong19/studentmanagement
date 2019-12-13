package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet) {
		try {
			Student student = new Student();
			student.setAddress(resultSet.getString("address"));
			student.setBirthday(resultSet.getTimestamp("birthday"));
			student.setFirstName(resultSet.getString("first_name"));
			student.setLastName(resultSet.getString("last_name"));
			student.setStudentID(resultSet.getInt("studentID"));
			student.setUsername(resultSet.getString("username"));
			student.setPassword(resultSet.getString("password"));
			student.setRoleID(resultSet.getInt("roleID"));
			return student;
		}catch(SQLException e) {
			return null;
		}
	}
	
}

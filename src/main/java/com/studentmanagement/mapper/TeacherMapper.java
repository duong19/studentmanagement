package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {

	public Teacher mapRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try{
			Teacher teacher = new Teacher();
		
		teacher.setUsername(resultSet.getString("username"));
		teacher.setPassword(resultSet.getString("password"));
		teacher.setName(resultSet.getString("teacher_name"));
		teacher.setAddress(resultSet.getString("address"));
		teacher.setBirthday(resultSet.getDate("birthday"));
		teacher.setRoleID(resultSet.getInt("roleID"));
		return teacher;
		}catch(SQLException e) {
			return null;
		}
	}
	

}

package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.Semester;

public class SemesterMapper implements RowMapper<Semester> {

	public Semester mapRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try {
			Semester semester = new Semester();
			semester.setSemester(resultSet.getString("semester"));
			return semester;
		}catch(SQLException e) {
			return null;
		}
	}

}

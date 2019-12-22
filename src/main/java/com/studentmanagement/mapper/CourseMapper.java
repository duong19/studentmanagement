package com.studentmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.model.Course;

public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet resultSet) {
		try {
			Course course = new Course();
			course.setCourseName(resultSet.getString("courseName"));
			course.setCourseID(resultSet.getString("courseID"));
			course.setCourseCredit(resultSet.getInt("courseCredit"));
			return course;
		}catch(SQLException e){
			return null;
		}
	}

}

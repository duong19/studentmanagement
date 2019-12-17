package com.studentmanagement.dao.imp;

import java.util.List;

import com.studentmanagement.dao.ICourseDAO;
import com.studentmanagement.mapper.CourseMapper;
import com.studentmanagement.model.Course;

public class CourseDAO extends AbstractDAO implements ICourseDAO {

	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from course");
		List<Course> courses = query(sql.toString(),new CourseMapper());
		return courses;
	}
	
}

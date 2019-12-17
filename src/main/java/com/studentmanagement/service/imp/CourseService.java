package com.studentmanagement.service.imp;

import java.util.List;

import javax.inject.Inject;

import com.studentmanagement.dao.ICourseDAO;
import com.studentmanagement.model.Course;
import com.studentmanagement.service.ICourseService;

public class CourseService implements ICourseService {

	@Inject
	private ICourseDAO courseDAO;
	
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseDAO.getAllCourses();
	}

}

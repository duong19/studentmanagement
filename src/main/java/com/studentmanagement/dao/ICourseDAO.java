package com.studentmanagement.dao;
import java.util.List;

import com.studentmanagement.model.Course;

public interface ICourseDAO {
	List<Course> getAllCourses();
}

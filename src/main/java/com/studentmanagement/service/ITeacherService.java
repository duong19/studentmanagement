package com.studentmanagement.service;

import com.studentmanagement.model.Teacher;

public interface ITeacherService {
	Teacher findByNameAndPassword(String username,String password);

}

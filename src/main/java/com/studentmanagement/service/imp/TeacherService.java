package com.studentmanagement.service.imp;

import javax.inject.Inject;

import com.studentmanagement.dao.ITeacherDAO;
import com.studentmanagement.model.Teacher;
import com.studentmanagement.service.ITeacherService;

public class TeacherService implements ITeacherService {

	@Inject
	private ITeacherDAO teacherDAO;
	public Teacher findByNameAndPassword(String username, String password) {
		return teacherDAO.findByUsernameAndPassword(username, password);
	}

}

package com.studentmanagement.service.imp;

import java.util.List;

import javax.inject.Inject;

import com.studentmanagement.dao.IStudentDAO;
import com.studentmanagement.model.Student;
import com.studentmanagement.service.IStudentService;

public class StudentService implements IStudentService {

	@Inject
	private IStudentDAO studentDAO;
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDAO.getAll();
	}

	public Student findByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return studentDAO.findByNameAndPassword(username, password);
	}

	public Integer save(Student newStudent) {
		// TODO Auto-generated method stub
		return studentDAO.save(newStudent);
	}

}

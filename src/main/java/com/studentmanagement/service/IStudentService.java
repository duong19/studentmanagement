package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.model.Student;

public interface IStudentService {
	public List<Student> getAll();
	public Student findByNameAndPassword(String username,String password);
	public Integer save(Student newStudent);
}

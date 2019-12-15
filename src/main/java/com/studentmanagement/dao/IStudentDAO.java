package com.studentmanagement.dao;
import java.util.List;

import com.studentmanagement.model.Student;

public interface IStudentDAO {
	public List<Student> getAll();
	public Student findByNameAndPassword(String username,String password);
	public Integer save(Student newStudent);
	public Student findOne(int studentID);
	public void update(Student updateStudent);
	public void delete(int studentID);
}

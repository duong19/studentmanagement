package com.studentmanagement.dao;
import java.util.List;

import com.studentmanagement.model.Student;

public interface IStudentDAO {
	public List<Student> getAll();
	public Student findByIDAndPassword(String studentID,String password);
	public Student save(Student newStudent);
	public Student findOne(String studentID);
	public void update(Student updateStudent);
	public void delete(String studentID);
}

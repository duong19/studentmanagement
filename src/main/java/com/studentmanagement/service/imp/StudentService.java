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

	public Student findByIDAndPassword(String studentID, String password) {
		// TODO Auto-generated method stub
		return studentDAO.findByIDAndPassword(studentID, password);
	}

	public Student save(Student newStudent) {
		// TODO Auto-generated method stub
		return studentDAO.save(newStudent);
	}

	public Student findOne(String studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findOne(studentID);
	}

	public Student update(Student updateStudent) {
		// TODO Auto-generated method stub
		Student student = new Student();
		if(studentDAO.update(updateStudent)) {
			student.setMessage("success");
			return student;
		}else {
			student.setMessage("failure");
			return student;
		}
		
	}

	public void delete(String studentID) {
		studentDAO.delete(studentID);
		
	}
	
}

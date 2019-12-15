package com.studentmanagement.service.imp;

import java.util.List;

import javax.inject.Inject;

import com.studentmanagement.dao.IStudentGradeDAO;
import com.studentmanagement.model.StudentGrade;
import com.studentmanagement.service.IStudentGradeService;

public class StudentGradeService implements IStudentGradeService {

	@Inject
	private IStudentGradeDAO studentGradeDAO;
	public List<StudentGrade> getAllGradeByStudentID(int studentID) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByStudentID(studentID);
	}

	public List<StudentGrade> getAllGrade() {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGrade();
	}

	public List<StudentGrade> getAllGradeByCourse(String courseName) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByCourse(courseName);
	}

	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseName, int semester) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByCourseAndSemester(courseName, semester);
	}

	public Integer save(StudentGrade studentGrade) {
		// TODO Auto-generated method stub
		return studentGradeDAO.save(studentGrade);
	}

	public void update(StudentGrade updateGrade) {
		studentGradeDAO.update(updateGrade);
		
	}

	public void delete(int gradeID) {
		// TODO Auto-generated method stub
		studentGradeDAO.deleteStudentGrade(gradeID);
	}

}

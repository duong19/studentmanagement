package com.studentmanagement.service.imp;

import java.util.List;

import javax.inject.Inject;

import com.studentmanagement.dao.IStudentGradeDAO;
import com.studentmanagement.model.Semester;
import com.studentmanagement.model.StudentGrade;
import com.studentmanagement.service.IStudentGradeService;

public class StudentGradeService implements IStudentGradeService {

	@Inject
	private IStudentGradeDAO studentGradeDAO;
	public List<StudentGrade> getAllGradeByStudentID(String studentID) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByStudentID(studentID);
	}

	public List<StudentGrade> getAllGrade() {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGrade();
	}

	public List<StudentGrade> getAllGradeByCourse(String courseID) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByCourse(courseID);
	}

	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseID, String semester) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeByCourseAndSemester(courseID, semester);
	}

	public StudentGrade save(StudentGrade studentGrade) {
		// TODO Auto-generated method stub
		return studentGradeDAO.save(studentGrade);
	}

	public StudentGrade update(StudentGrade updateGrade) {
		StudentGrade grade = new StudentGrade();
		if(studentGradeDAO.update(updateGrade)) {
			grade.setMessage("success");
			return grade;
		}else {
			grade.setMessage("failure");
			return grade;
		}
		
	}

	public void delete(int gradeID) {
		// TODO Auto-generated method stub
		studentGradeDAO.deleteStudentGrade(gradeID);
	}

	public List<StudentGrade> getAllGradeBySemester(String semester) {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllGradeBySemester(semester);
	}

	public List<Semester> getAllSemester() {
		// TODO Auto-generated method stub
		return studentGradeDAO.getAllSemester();
	}

}

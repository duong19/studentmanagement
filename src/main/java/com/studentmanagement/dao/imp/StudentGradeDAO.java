package com.studentmanagement.dao.imp;

import java.util.List;

import com.studentmanagement.dao.IStudentGradeDAO;
import com.studentmanagement.mapper.StudentGradeMapper;
import com.studentmanagement.model.StudentGrade;

public class StudentGradeDAO extends AbstractDAO implements IStudentGradeDAO {

	public List<StudentGrade> getAllGradeByStudentID(int studentID) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c\r\n"
												+ " where sg.studentID = " + studentID
												+ " and sg.courseID = c.courseID\r\n");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGrade() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c\r\n"
				+ "where sg.courseID = c.courseID\r\n");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGradeByCourse(String courseName) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c, semester s\r\n"
				+ " where c.courseName = '" + courseName + "'\r\n" 
				+ " and sg.courseID = c.courseID\r\n");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public List<StudentGrade> getAllGradeByCourseAndSemester(String courseName, int semester) {
		StringBuilder sql = new StringBuilder("select * from studentgrade sg,course c\r\n"
				+ " where c.courseName = '" + courseName + "'\r\n"
				+ "and c.semester =" + semester + "\r\n" 
				+ " and sg.courseID = c.courseID\r\n");
		List<StudentGrade> studentGrades = query(sql.toString(),new StudentGradeMapper());
		return studentGrades;
	}

	public Integer save(StudentGrade studentGrade) {
		StringBuilder sql = new StringBuilder("insert into studentgrade (studentID,");
		sql.append("courseID,grade1,grade2,semester) ");
		sql.append("values (?,?,?,?,?)");
		return insert(sql.toString(),studentGrade.getStudentID(),studentGrade.getCourseID(),
						studentGrade.getGrade1(),studentGrade.getGrade2(),studentGrade.getSemester());

	}

	public void update(StudentGrade updateGrade) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("update studentgrade set studentID = ?,");
		sql.append("courseID = ?,semester = ?,grade1 = ?,grade2 = ? where gradeID = ?");
		update(sql.toString(),updateGrade.getStudentID(),updateGrade.getCourseID(),
				updateGrade.getSemester(),updateGrade.getGrade1(),updateGrade.getGrade2(),
				updateGrade.getGradeID());
		
		
	}

	public void deleteStudentGrade(int gradeID) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("delete from studentgrade where gradeID = " + gradeID);
		update(sql.toString());
		
		
	}

}

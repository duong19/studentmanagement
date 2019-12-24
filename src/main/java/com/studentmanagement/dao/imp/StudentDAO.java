package com.studentmanagement.dao.imp;

import java.util.List;

import com.studentmanagement.dao.IStudentDAO;
import com.studentmanagement.mapper.StudentMapper;
import com.studentmanagement.model.Student;

public class StudentDAO extends AbstractDAO implements IStudentDAO {

	public List<Student> getAll() {
		StringBuilder sql = new StringBuilder("select address,s.roleID,student_name,date_format(birthday,'%d/%m/%Y') birthday," +
				"studentID,password,faculty \r\n" +
				"from student s \r\n" +
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n");
		List<Student> students = query(sql.toString(),new StudentMapper());
		return students;
		
		
	}

	public Student findByIDAndPassword(String studentID, String password) {
		StringBuilder sql = new StringBuilder("select address,s.roleID,student_name,date_format(birthday,'%d/%m/%Y') birthday," +
				"studentID,password,faculty \r\n" +
				"from student s\r\n"+
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n" +
				"where studentID = '" + studentID +"' and password = '" + password +"'");
		List<Student> students = query(sql.toString(),new StudentMapper());
		if(students.isEmpty()) {
			Student student = new Student();
			student.setMessage("failure");
			return student;
		}else {
			return students.get(0);
		}
	}

	public Student save(Student newStudent) {
		StringBuilder sql = new StringBuilder("insert into student (studentID,student_name,");
		sql.append("birthday,address,password,roleID,faculty)");
		sql.append("values (?,?,str_to_date(?,'%d/%m/%Y'),?,?,2,?)");
		return insertStudent(sql.toString(),newStudent.getStudentID(),newStudent.getName(),newStudent.getBirthday(),newStudent.getAddress(),
						newStudent.getPassword(),newStudent.getFaculty());
	}

	public Student findOne(String studentID) {
		StringBuilder sql = new StringBuilder("select * from student s\r\n"+
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n" +
				"where studentID = " + studentID);
		List<Student> students = query(sql.toString(),new StudentMapper());
		return students.get(0);
		
	}

	public boolean update(Student updateStudent) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("update student set student_name = ?,");
		sql.append("birthday = str_to_date(?,'%d/%m/%Y') ,address = ?,password = ?,faculty=? where studentID = ? and student_name = ? \r\n");
		return update(sql.toString(),updateStudent.getName(),updateStudent.getBirthday(),updateStudent.getAddress(),
			updateStudent.getPassword(),updateStudent.getFaculty(),updateStudent.getStudentID(),updateStudent.getName());
		
	}

	public boolean delete(String studentID) {
		StringBuilder sql = new StringBuilder("delete from studentgrade where studentID = " + studentID + ";\r\n");
		 sql.append("delete from student where studentID = " + studentID);
		return update(sql.toString());
		
	}

	
	
	
}

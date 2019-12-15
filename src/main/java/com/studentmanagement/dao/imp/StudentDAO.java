package com.studentmanagement.dao.imp;

import java.util.List;

import com.studentmanagement.dao.IStudentDAO;
import com.studentmanagement.mapper.StudentMapper;
import com.studentmanagement.model.Student;

public class StudentDAO extends AbstractDAO implements IStudentDAO {

	public List<Student> getAll() {
		StringBuilder sql = new StringBuilder("select * from student s inner join user u\r\n"+
				"on s.userID = u.userID\r\n" +
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n");
		List<Student> students = query(sql.toString(),new StudentMapper());
		return students;
		
		
	}

	public Student findByNameAndPassword(String username, String password) {
		StringBuilder sql = new StringBuilder("select * from student s\r\n"+
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n" +
				"where username = '" + username +"' and password = '" + password +"'");
		List<Student> students = query(sql.toString(),new StudentMapper());
		return students.get(0);
	}

	public Integer save(Student newStudent) {
		StringBuilder sql = new StringBuilder("insert into student (student_name,");
		sql.append("birthday,address,username,password,roleID)");
		sql.append("values (?,?,?,?,?,2)");
		return insert(sql.toString(),newStudent.getName(),newStudent.getBirthday(),newStudent.getAddress(),
						newStudent.getUsername(),newStudent.getPassword());
	}

	public Student findOne(int studentID) {
		StringBuilder sql = new StringBuilder("select * from student s\r\n"+
				"inner join role r\r\n" +
				"on s.roleID = r.roleID\r\n" +
				"where studentID = " + studentID);
		List<Student> students = query(sql.toString(),new StudentMapper());
		return students.get(0);
		
	}

	public void update(Student updateStudent) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("update student set student_name = ?,");
		sql.append("birthday = ?,address = ?, username = ?,password = ? where studentID = ? \r\n");
		update(sql.toString(),updateStudent.getName(),updateStudent.getBirthday(),updateStudent.getAddress(),
				updateStudent.getUsername(),updateStudent.getPassword(),updateStudent.getRoleID(),updateStudent.getStudentID());
		
	}

	public void delete(int studentID) {
		StringBuilder sql = new StringBuilder("delete from studentgrade where studentID = " + studentID + ";\r\n");
		 sql.append("delete from student where studentID = " + studentID);
		 update(sql.toString());
		
	}

	
	
	
}

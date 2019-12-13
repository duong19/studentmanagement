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
		StringBuilder sql = new StringBuilder("insert into student (first_name,last_name,");
		sql.append("birthday,address,username,password,roleID)");
		sql.append("values (?,?,?,?,?,?,2)");
		return insert(sql.toString(),newStudent.getFirstName(),newStudent.getLastName(),newStudent.getBirthday(),newStudent.getAddress(),
						newStudent.getUsername(),newStudent.getPassword(),newStudent.getRoleID());
	}

	
	
	
}

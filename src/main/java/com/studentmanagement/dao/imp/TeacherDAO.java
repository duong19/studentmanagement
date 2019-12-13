package com.studentmanagement.dao.imp;



import java.util.List;

import com.studentmanagement.dao.ITeacherDAO;
import com.studentmanagement.mapper.TeacherMapper;
import com.studentmanagement.model.Teacher;

public class TeacherDAO  extends AbstractDAO implements ITeacherDAO {

	public Teacher findByUsernameAndPassword(String username, String password) {
		StringBuilder sql = new StringBuilder("select * from teacher t\r\n"+
												"inner join role r\r\n" +
												"on t.roleID = r.roleID\r\n" +
												"where username = '" + username +"' and password = '" + password +"'");
		List<Teacher> teachers = query(sql.toString(),new TeacherMapper());
		if(teachers.isEmpty()) {
			return null;
		}
		return teachers.get(0);
		
	}


	
	
	
	

	

}

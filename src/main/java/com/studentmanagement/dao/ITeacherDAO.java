package com.studentmanagement.dao;



import com.studentmanagement.model.Teacher;
public interface ITeacherDAO {
	public Teacher findByUsernameAndPassword(String username, String password);
}

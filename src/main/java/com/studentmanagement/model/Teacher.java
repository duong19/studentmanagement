package com.studentmanagement.model;


public class Teacher extends Person {
	private Integer teacherID;
	private String username;
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

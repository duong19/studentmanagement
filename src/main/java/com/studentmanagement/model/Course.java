package com.studentmanagement.model;

import java.sql.Timestamp;

public class Course {
	private int courseID;
	private int courseName;
	private int courseCredit;
	private Timestamp year;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public Timestamp getYear() {
		return year;
	}
	public void setYear(Timestamp year) {
		this.year = year;
	}
	
}

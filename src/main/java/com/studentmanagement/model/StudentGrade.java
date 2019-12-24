package com.studentmanagement.model;

public class StudentGrade extends Abstract {
	private String studentID;
	private String courseID;
	private String courseName;
	private String semester;
	private int credit;
	private float grade1;
	private float grade2;
	private float midCredit;
	private float endCredit;
	
	private int gradeID;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public float getGrade1() {
		return grade1;
	}
	public void setGrade1(float grade) {
		this.grade1 = grade;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getGradeID() {
		return gradeID;
	}
	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}
	public float getGrade2() {
		return grade2;
	}
	public void setGrade2(float grade2) {
		this.grade2 = grade2;
	}
	public float getEndCredit() {
		return endCredit;
	}
	public void setEndCredit(float endCredit) {
		this.endCredit = endCredit;
	}
	public float getMidCredit() {
		return midCredit;
	}
	public void setMidCredit(float midCredit) {
		this.midCredit = midCredit;
	}
	
}

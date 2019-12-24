package com.studentmanagement.controller.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentmanagement.model.StudentGrade;
import com.studentmanagement.service.IStudentGradeService;
import com.studentmanagement.util.HttpUtil;

@WebServlet("/api-teacher-grade")
public class StudentGradeAPI extends HttpServlet {

	@Inject
	private IStudentGradeService studentGradeService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String courseID = request.getParameter("courseID");
		String semester = request.getParameter("semester");
		List<StudentGrade> grades;
		if (courseID != ""  && semester != "") {
			 grades = studentGradeService.getAllGradeByCourseAndSemester(courseID, semester);
		} else if (courseID != "" && semester == "") {
			 grades = studentGradeService.getAllGradeByCourse(courseID);
		} else if (courseID == "" && semester != "") {
			 grades = studentGradeService.getAllGradeBySemester(semester);
		} else {
			 grades = studentGradeService.getAllGrade();
		}
		mapper.writeValue(response.getOutputStream(), grades);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		StudentGrade grade = HttpUtil.of(request.getReader()).toModel(StudentGrade.class);
		grade = studentGradeService.save(grade);
		mapper.writeValue(response.getOutputStream(),grade);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		StudentGrade grade = HttpUtil.of(request.getReader()).toModel(StudentGrade.class);
		grade = studentGradeService.update(grade);
		mapper.writeValue(response.getOutputStream(),grade);

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		StudentGrade grade = new StudentGrade();
		String id = request.getParameter("gradeID");
		if(id != null) {
			Integer gradeID = Integer.parseInt(id);
			studentGradeService.delete(gradeID);
			grade.setMessage("success");
			mapper.writeValue(response.getOutputStream(), grade);

			
		}

	}

}

package com.studentmanagement.controller.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentmanagement.model.Student;
import com.studentmanagement.service.IStudentService;
import com.studentmanagement.util.HttpUtil;

@WebServlet("/api-teacher-student")
public class StudentAPI extends HttpServlet {
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Student updateStudent = HttpUtil.of(request.getReader()).toModel(Student.class);
		updateStudent = studentService.update(updateStudent);
		mapper.writeValue(response.getOutputStream(), updateStudent);
		
	}


	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Student student = HttpUtil.of(request.getReader()).toModel(Student.class);
		studentService.delete(student.getStudentID());
		mapper.writeValue(response.getOutputStream(), "{}");

		

	}


	@Inject
	private IStudentService studentService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Student student = HttpUtil.of(request.getReader()).toModel(Student.class);
		Integer id = studentService.save(student);
		student = studentService.findOne(id);
		mapper.writeValue(response.getOutputStream(),student);
		
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}

package com.studentmanagement.controller.student;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.IStudentService;

@WebServlet("/student-home")
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IStudentService studentService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = studentService.findOne(1);
		System.out.println(student.getName());
		request.setAttribute("student", student);
		response.sendRedirect(request.getContextPath() + "/student-home");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = studentService.findOne(1);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/views/student/student.jsp");
		rd.forward(request, response);
		
	}
	
}

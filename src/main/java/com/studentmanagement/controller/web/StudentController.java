package com.studentmanagement.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.model.Student;
import com.studentmanagement.model.StudentGrade;
import com.studentmanagement.service.IStudentGradeService;
import com.studentmanagement.service.IStudentService;
import com.studentmanagement.util.SessionUtil;

@WebServlet("/student-home")
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IStudentService studentService;
	@Inject
	private IStudentGradeService gradeService;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = studentService.findByIDAndPassword(request.getParameter("username"),
				request.getParameter("password"));
		if(student.getMessage().equals("success")) {
			request.setAttribute("student", student);
			if(student != null && student.getRoleID() == 2) {
				List<StudentGrade> grades = gradeService.getAllGradeByStudentID(student.getStudentID());
				SessionUtil.getInstance().putValue(request, "student", student);
				SessionUtil.getInstance().putValue(request, "grades", grades);
				request.setAttribute("grades", grades);
				response.sendRedirect(request.getContextPath()+"/student-home");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
				
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
			
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/student/student.jsp");
		rd.forward(request, response);
		
	}
	
}

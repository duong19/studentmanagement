package com.studentmanagement.controller.teacher;


import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentmanagement.model.Course;
import com.studentmanagement.service.ICourseService;
@WebServlet(urlPatterns = {"/teacher-home"})
public class TeacherController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ICourseService courseService;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/teacher-home");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> courses =  courseService.getAllCourses();
		request.setAttribute("courses",courses);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/teacher.jsp");
		rd.forward(request, response);
		
	}
	

}

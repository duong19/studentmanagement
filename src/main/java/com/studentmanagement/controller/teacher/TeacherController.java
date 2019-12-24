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
import com.studentmanagement.model.Semester;
import com.studentmanagement.model.Teacher;
import com.studentmanagement.service.ICourseService;
import com.studentmanagement.service.IStudentGradeService;
import com.studentmanagement.service.ITeacherService;
import com.studentmanagement.util.SessionUtil;
@WebServlet(urlPatterns = {"/teacher-home"})
public class TeacherController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ICourseService courseService;
	@Inject
	private IStudentGradeService gradeService;
	@Inject 
	private ITeacherService teacherService;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher = teacherService.findByNameAndPassword(request.getParameter("username"),
							request.getParameter("password"));
		if(teacher.getMessage().equals("success")) {
			request.setAttribute("teacher",teacher);
			if(teacher != null && teacher.getRoleID() == 1) {
				SessionUtil.getInstance().putValue(request, "teacher", teacher);
				response.sendRedirect(request.getContextPath() + "/teacher-home");
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
		List<Course> courses =  courseService.getAllCourses();
		List<Semester> semesters = gradeService.getAllSemester();
		request.setAttribute("courses",courses);
		request.setAttribute("semesters",semesters);
		try {
			Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
			if (teacher.getTeacherID() != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/teacher.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		
	}
	

}

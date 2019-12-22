package com.studentmanagement.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })

public class MainController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("action");
		if (status.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String usertype = request.getParameter("usertype");
		if (action != null && action.equals("login")) {
			/* StudentModel model = FormUtil.toModel(StudentModel.class, request); */
			if (usertype.equals("student")) {
				RequestDispatcher rd = request.getRequestDispatcher("/student-home");
				rd.forward(request, response);
			}else if(usertype.equals("teacher")) {
				RequestDispatcher rd = request.getRequestDispatcher("/teacher-home");
				rd.forward(request, response);
			}
		}
		
	}
	

}

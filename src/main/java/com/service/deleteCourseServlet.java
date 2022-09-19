package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CourseService;
import com.dbcon.CourseServiceImpl;
import com.dbcon.showIO;

/**
 * Servlet implementation class deleteCourseServlet
 */
@WebServlet("/deleteCourseServlet")
public class deleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deleteAccount = request.getParameter("delCourseID");
		String opereation = "Administrator delete course:"+deleteAccount;
		showIO.writeHistory (opereation);
		
		CourseService courseService = new CourseServiceImpl();
		courseService.courseDelete(deleteAccount);
		doGet(request, response);
	}

}

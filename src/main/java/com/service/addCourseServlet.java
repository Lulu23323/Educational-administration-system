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
 * Servlet implementation class addCourseServlet
 */
@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCourseServlet() {
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
		String ID = request.getParameter("course_ID");
		String name = request.getParameter("course_name");
		String academy = request.getParameter("course_academy");
		String major = request.getParameter("course_major");
		String intro = request.getParameter("course_intro");

		
		
		CourseService courseService = new CourseServiceImpl();
		courseService.courseCreate(ID,name,academy, major, intro);
		
		String opereation = "Administrator add course:"+name;		
		showIO.writeHistory (opereation);
		
		doGet(request, response);
	}

}

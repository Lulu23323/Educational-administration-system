package com.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CourseEntity;
import com.dbcon.CourseService;
import com.dbcon.CourseServiceImpl;
import com.dbcon.StudentEntity;
import com.dbcon.StudentService;
import com.dbcon.StudentServiceImpl;
import com.dbcon.showIO;
import com.json.JSONUtils;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class showCoursesServlet
 */
@WebServlet("/showCoursesServlet")
public class showCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showCoursesServlet() {
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
		
		CourseService courseService = new CourseServiceImpl();
		List<CourseEntity> CourseEntityList = courseService.select();
		
		String opereation = "Administrator show all course";
		showIO.writeHistory (opereation);
		
		JSONArray course = JSONArray.fromObject(CourseEntityList);
		response.getWriter().append(course.toString());
		
		System.out.println(course.toString());
		
	}

}

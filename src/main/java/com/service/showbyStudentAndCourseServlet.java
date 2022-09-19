package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.GradeEntity;
import com.dbcon.GradeService;
import com.dbcon.GradeServiceImpl;
import com.dbcon.showIO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class showbyStudentAndCourseServlet
 */
@WebServlet("/showbyStudentAndCourseServlet")
public class showbyStudentAndCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showbyStudentAndCourseServlet() {
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
		

		
		String account = request.getParameter("studentID");
		String course = request.getParameter("courseID");
		
		String opereation = "Administrator check grades by Student ID"+account+" and course ID"+course;
		showIO.writeHistory (opereation);
		
		GradeService gradeService = new GradeServiceImpl();
		GradeEntity grade = gradeService.gradeSearch(course,account);
		
		JSONArray g = JSONArray.fromObject(grade);		
		response.getWriter().append(g.toString());
		
		
//		doGet(request, response);
	}

}

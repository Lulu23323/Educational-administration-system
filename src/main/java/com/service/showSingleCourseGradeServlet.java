package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class showSingleCourseGradeServlet
 */
@WebServlet("/showSingleCourseGradeServlet")
public class showSingleCourseGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSingleCourseGradeServlet() {
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
//		String account = "2108J";
		
		String account = request.getParameter("courseID");
		
		String opereation = "Check all students' grades in course"+ account;
		showIO.writeHistory (opereation);
		
		GradeService gradeService = new GradeServiceImpl();
		List<GradeEntity> grade = gradeService.selectByCourseAccount(account);
		
		System.out.println("grade"+grade.get(0));	
		JSONArray g = JSONArray.fromObject(grade);
		
		response.getWriter().append(g.toString());
		
		System.out.println("ok22");
		System.out.println(g.toString());
	}

}

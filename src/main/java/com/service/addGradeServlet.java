package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.GradeService;
import com.dbcon.GradeServiceImpl;
import com.dbcon.showIO;

/**
 * Servlet implementation class addGradeServlet
 */
@WebServlet("/addGradeServlet")
public class addGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGradeServlet() {
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
		System.out.println("get success");
		String StuID = request.getParameter("stu_ID");
		String StuName = request.getParameter("stu_name");
		String StuAca = request.getParameter("stu_academy");
		String StuMaj = request.getParameter("stu_major");
		String StuCouID = request.getParameter("stu_course");
		String StuGra = request.getParameter("stu_grade");
		System.out.println(StuID);
		
		GradeService gradeService = new GradeServiceImpl();
		gradeService.gradeCreate(StuCouID,StuID,StuAca,StuMaj,StuGra);
		
		
		String opereation = "Administrator add student(:"+StuID+") grade:"+StuGra+"for course"+StuCouID;		
		showIO.writeHistory (opereation);
		
		System.out.println("add success");
		
		doGet(request, response);
	}

}

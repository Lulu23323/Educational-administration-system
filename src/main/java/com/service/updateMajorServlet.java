package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CollegeService;
import com.dbcon.CollegeServiceImpl;
import com.dbcon.MajorService;
import com.dbcon.MajorServiceImpl;
import com.dbcon.showIO;

/**
 * Servlet implementation class updateMajorServlet
 */
@WebServlet("/updateMajorServlet")
public class updateMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMajorServlet() {
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
		String majorAccount = request.getParameter("major_id");
		String major = request.getParameter("major_name");
		String college = request.getParameter("major_aca");
		String majorIntro = request.getParameter("major_intro");
		
		System.out.println(majorAccount+ major+ college+ majorIntro);
		
		String opereation = "Administrator update major "+major+"in colledge"+college;
		showIO.writeHistory (opereation);
		
		MajorService majorService = new MajorServiceImpl();
	    majorService.majorUpdate( majorAccount, major, college,  majorIntro);
		
		doGet(request, response);
	}

}

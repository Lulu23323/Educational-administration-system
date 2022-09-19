package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CollegeService;
import com.dbcon.CollegeServiceImpl;
import com.dbcon.CourseService;
import com.dbcon.CourseServiceImpl;
import com.dbcon.showIO;

/**
 * Servlet implementation class updateCollegeServlet
 */
@WebServlet("/updateCollegeServlet")
public class updateCollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCollegeServlet() {
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
		
		String aca_id = request.getParameter("aca_id");
		String aca_name = request.getParameter("aca_name");
		String aca_intro = request.getParameter("aca_intro");
		System.out.println(aca_id+aca_name+aca_intro);
		
		String opereation = "Administrator update academy "+aca_id;
		showIO.writeHistory (opereation);
		
		CollegeService collegeService = new CollegeServiceImpl();
		 collegeService.collegeUpdate( aca_id,aca_name, aca_intro);
		
		doGet(request, response);
	}

}

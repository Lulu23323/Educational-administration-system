package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CollegeService;
import com.dbcon.CollegeServiceImpl;
import com.dbcon.showIO;


/**
 * Servlet implementation class addCollegeServlet
 */
@WebServlet("/addCollegeServlet")
public class addCollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCollegeServlet() {
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
		String ID = request.getParameter("academy_ID");
		String name = request.getParameter("academy_name");
		String intro = request.getParameter("academy_intro");
		
		
		CollegeService collegeService = new CollegeServiceImpl();
		collegeService.collegeCreate(ID,name,intro);
		
		String opereation = "Administrator add academy: ID:"+ID+" name"+name+" introduction"+intro;		
		showIO.writeHistory (opereation);
		doGet(request, response);
	}

}

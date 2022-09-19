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
 * Servlet implementation class addMajorServlet
 */
@WebServlet("/addMajorServlet")
public class addMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMajorServlet() {
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
		String ID = request.getParameter("major_ID");
		String name = request.getParameter("major_name");
		String academy = request.getParameter("major_academy");
		String intro = request.getParameter("major_intro");
		
		String opereation = "Administrator add major:"+ID;
		showIO.writeHistory (opereation);
		
		
		
		
		MajorService majorService = new MajorServiceImpl();
		majorService.majorCreate(ID,name,academy,intro);
		doGet(request, response);
	}

}

package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.GradeService;
import com.dbcon.GradeServiceImpl;
import com.dbcon.PersonalFileService;
import com.dbcon.PersonalFileServiceImpl;
import com.dbcon.showIO;


/**
 * Servlet implementation class updateGradeServlet
 */
@WebServlet("/updateGradeServlet")
public class updateGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGradeServlet() {
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
		String StuID = request.getParameter("ChangeStuID");
		System.out.println(StuID+"Come here");
		String StuCouID = request.getParameter("ChangeStuCouID");
		String StuGra = request.getParameter("ChangeStuGra");
		
		String opereation = "Administrator up date student("+StuID+")'s grade"+StuGra+" on course"+StuGra;
		showIO.writeHistory (opereation);
		
		GradeService gradeService = new GradeServiceImpl();
		gradeService.gradeUpdate(StuCouID,StuID,StuGra);
		
		System.out.println(StuID);
		
		doGet(request, response);
	}

}

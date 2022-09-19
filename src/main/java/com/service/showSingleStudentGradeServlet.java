package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.GradeDetailEntity;
import com.dbcon.GradeEntity;
import com.dbcon.GradeService;
import com.dbcon.GradeServiceImpl;
import com.dbcon.showIO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class showSingleStudentGradeServlet
 */
@WebServlet("/showSingleStudentGradeServlet")
public class showSingleStudentGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSingleStudentGradeServlet() {
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
		System.out.println("ok");
		
		String account = request.getParameter("studentID");
//		String account = "20372101";
		System.out.println("收到的id"+account);
		
		GradeService gradeService = new GradeServiceImpl();
		List<GradeDetailEntity> grade = gradeService.getDetailsByStudent(account);
//		List<GradeEntity> grade = gradeService.selectByAccount(account);
		
		
		JSONArray g = JSONArray.fromObject(grade);
		response.getWriter().append(g.toString());
		String opereation = "Student " +account+" check course ";
		showIO.writeHistory (opereation);
		System.out.println("ok33");
		System.out.println("返回的内容"+g.toString());
	}

}

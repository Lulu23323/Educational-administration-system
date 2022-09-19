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
 * Servlet implementation class StudentGradeDataServlet
 */
@WebServlet("/StudentGradeDataServlet")
public class StudentGradeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeDataServlet() {
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
		
		String opereation = "Administrator show char";
		showIO.writeHistory (opereation);
		
		GradeService gradeService = new GradeServiceImpl();
		List<GradeEntity> grade = gradeService.selectByAccount(account);
		
		List<Object> data = new ArrayList<Object>();
		
		for (int i=0; i<grade.size(); i++) {
			Map<Object, Object> map = new HashMap<>();
			map.put(grade.get(i).getCourseAccount(), grade.get(i).getGrade());
			data.add(map);
		}
		
		JSONArray d = JSONArray.fromObject(data);
		
		response.getWriter().append(d.toString());

		System.out.println(d.toString());
	}

}

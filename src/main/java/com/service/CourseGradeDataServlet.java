package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
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
import com.dbpool.DBConnection;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CourseGradeDataServlet
 */
@WebServlet("/CourseGradeDataServlet")
public class CourseGradeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseGradeDataServlet() {
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
		System.out.println("show data");
		String opereation = "Administrator show figure";
		showIO.writeHistory (opereation);
		
		String account = request.getParameter("courseID");
		GradeService gradeService = new GradeServiceImpl();
		List<GradeEntity> grade = gradeService.selectByCourseAccount(account);
		int students = grade.size();
		
		List<Object> data = new ArrayList<Object>();
		
//		A
		Map<Object, Object> mapA = new HashMap<>();
		mapA.put("A", calculate(grade, "A"));
		data.add(mapA);
		
		Map<Object, Object> mapA2 = new HashMap<>();
		mapA2.put("Ap", percentage(calculate(grade, "A"), students));
		data.add(mapA2);
		
//		B
		Map<Object, Object> mapB = new HashMap<>();
		mapB.put("B", calculate(grade, "B"));
		data.add(mapB);
		
		Map<Object, Object> mapB2 = new HashMap<>();
		mapB2.put("Bp", percentage(calculate(grade, "B"), students));
		data.add(mapB2);
		
//		C
		Map<Object, Object> mapC = new HashMap<>();
		mapC.put("C", calculate(grade, "C"));
		data.add(mapC);
		
		Map<Object, Object> mapC2 = new HashMap<>();
		mapC2.put("Cp", percentage(calculate(grade, "C"), students));
		data.add(mapC2);
		
//		D
		Map<Object, Object> mapD = new HashMap<>();
		mapD.put("D", calculate(grade, "D"));
		data.add(mapD);
		
		Map<Object, Object> mapD2 = new HashMap<>();
		mapD2.put("Dp", percentage(calculate(grade, "D"), students));
		data.add(mapD2);
		
//		E
		Map<Object, Object> mapE = new HashMap<>();
		mapE.put("E", calculate(grade, "E"));
		data.add(mapE);
		
		Map<Object, Object> mapE2 = new HashMap<>();
		mapE2.put("Ep", percentage(calculate(grade, "E"), students));
		data.add(mapE2);
		
//		F
		Map<Object, Object> mapF = new HashMap<>();
		mapF.put("F", calculate(grade, "F"));
		data.add(mapF);
		
		Map<Object, Object> mapF2 = new HashMap<>();
		mapF2.put("Fp", percentage(calculate(grade, "F"), students));
		data.add(mapF2);
		
		JSONArray d = JSONArray.fromObject(data);
		
		response.getWriter().append(d.toString());
		
		System.out.println(d.toString());
	}
	
	public static int calculate(List<GradeEntity> g, String s){
		int num = 0;
		for (int i=0; i<g.size(); i++) {
			if (g.get(i).getGrade().equals(s)) {
				num = num + 1;
			}
		}
		return num;
	}
	
	public static String percentage(int a, int b){
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) a/(float) b * 100);
		return result+"%";
	}

}

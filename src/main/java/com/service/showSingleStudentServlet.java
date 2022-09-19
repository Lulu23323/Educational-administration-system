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

import com.dbcon.PersonalFileEntity;
import com.dbcon.PersonalFileService;
import com.dbcon.PersonalFileServiceImpl;
import com.dbcon.showIO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class showSingleStudentServlet
 */
@WebServlet("/showSingleStudentServlet")
public class showSingleStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSingleStudentServlet() {
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
		
		System.out.println("show");
		
//		String account = "20372101";
		String account = request.getParameter("stu_id");
//		System.out.println(account);
		
		String opereation = "Check all couses grades for student"+ account;
		showIO.writeHistory (opereation);
		
		PersonalFileService personalService = new PersonalFileServiceImpl();
		PersonalFileEntity personal = personalService.personalFileSearch(account);
		System.out.println("account"+personal.getAccount());
		List<Object> t = new ArrayList<Object>();
		Map<Object, Object> map = new HashMap<>();
		map.put("account", personal.getAccount());
		map.put("fullName", personal.getFullName());
		map.put("college", personal.getCollege());
		map.put("major", personal.getMajor());
		map.put("classNumber", personal.getClassNumber());
		String gen = "2";
		if(personal.getGender()=="Male") {
			gen = "1";
		}else if(personal.getGender()=="Female") {
			gen = "2";
		}else {
			gen = "2";
		}
		System.out.println("判断性别");
		map.put("gender", gen);
		map.put("phonenumber", personal.getPhonenumber());
		map.put("idnumber", personal.getIdnumber());
		map.put("beginage", personal.getBeginage());
		map.put("email", personal.getEmail());
		map.put("introduction", personal.getIntroduction());
		System.out.println("加入map");
		t.add(map);
		System.out.println("打包"+t.toString());
		
		JSONArray per = JSONArray.fromObject(t);
		
		response.getWriter().append(per.toString());

		System.out.println(per.toString());
		
	}

}

package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.StudentService;
import com.dbcon.StudentServiceImpl;
import com.dbcon.showIO;
import com.json.JSONUtils;

import net.sf.json.JSONArray;

import com.dbcon.StudentEntity;

/**
 * Servlet implementation class showStudentServlet
 */
@WebServlet("/showStudentServlet")
public class showStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: 123").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opereation = "Administrator show all students";
		showIO.writeHistory (opereation);
		
		StudentService studentService = new StudentServiceImpl();
		List<StudentEntity> studentEntityList = studentService.selectInOrder();
		Iterator<StudentEntity> var = studentEntityList.iterator();
		
		
		JSONArray json = JSONUtils.toJSONObject(var);
		
		
//		List<Object> t = new ArrayList<Object>();
//		Map<Object, Object> map1 = new HashMap<>();
//		map1.put("account", 1);
//		map1.put("fullName", 2);
//		map1.put("college", 2);
//		map1.put("major", 2);
//		map1.put("classNumber", 2);
//		t.add(map1);
//		Map<Object, Object> map2 = new HashMap<>();
//		map2.put("account", 1);
//		map2.put("fullName", 2);
//		map2.put("college", 2);
//		map2.put("major", 2);
//		map2.put("classNumber", 2);
//		t.add(map2);
//		
//		System.out.println("ok3");
//
//		JSONArray test = JSONArray.fromObject(t);
//		
//		System.out.println("ok4");
		
		
		response.getWriter().append(json.toString());
		
		System.out.println(json.toString());
		
//		request.setAttribute("json", test);
//		
//		request.setAttribute("json", json);
		
//		doGet(request, response);
	}

}

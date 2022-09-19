package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.StudentService;
import com.dbcon.StudentServiceImpl;
import com.dbcon.showIO;
import com.dbpool.DBConnection;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentServlet() {
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
		//得到参数

		String stu_name = request.getParameter("stu_name");
		String stu_account = request.getParameter("stu_ID");
		String stu_college = request.getParameter("stu_academy");
		String stu_major = request.getParameter("stu_major");
		String stu_class = request.getParameter("stu_class");
		

		StudentService studentService = new StudentServiceImpl();
		studentService.studentCreate(stu_account, stu_name, stu_college, stu_major, stu_class);

		String opereation = "Administrator add student:"+stu_account;
		showIO.writeHistory (opereation);
		
		doGet(request, response);
	}

}

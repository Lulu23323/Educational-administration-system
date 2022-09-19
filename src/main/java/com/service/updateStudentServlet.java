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

/**
 * Servlet implementation class updateStudentServlet
 */
@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
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
		// TODO Auto-generated method stub
		String stu_name = request.getParameter("ChangeStuName");
		String stu_account = request.getParameter("ChangeStuID");
		String stu_college = request.getParameter("ChangeStuAcademy");
		String stu_major = request.getParameter("ChangeStuMajor");
		String stu_class = request.getParameter("ChangeStuClass");

		String opereation = "Administrator up date student("+stu_account+")'s information: name"+stu_name+" academy"+stu_college+" major"+stu_major+" class"+stu_class;
		showIO.writeHistory (opereation);
		
		StudentService studentService = new StudentServiceImpl();
		studentService.studentUpdate(stu_account, stu_name, stu_college, stu_major, stu_class);
	
		
		doGet(request, response);
	}

}

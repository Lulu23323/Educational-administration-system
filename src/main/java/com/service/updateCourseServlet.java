package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.CourseService;
import com.dbcon.CourseServiceImpl;
import com.dbcon.showIO;

/**
 * Servlet implementation class updateCourseServlet
 */
@WebServlet("/updateCourseServlet")
public class updateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCourseServlet() {
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
		String cour_name = request.getParameter("ChangeCourseName");
		String cour_account = request.getParameter("ChangeCourseID");
		String cour_college = request.getParameter("ChangeCourseAcademy");
		String cour_major = request.getParameter("ChangeCourseMajor");
		String cour_Infor = request.getParameter("ChangeCourseInfor");
		
		String opereation = "Administrator update course "+cour_account+" information";
		showIO.writeHistory (opereation);
		
		CourseService courseService = new CourseServiceImpl();
		courseService.courseUpdate( cour_account,cour_name, cour_college,cour_major, cour_Infor);
		doGet(request, response);
	}

}

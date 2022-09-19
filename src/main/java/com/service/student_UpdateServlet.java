package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.PersonalFileService;
import com.dbcon.PersonalFileServiceImpl;
import com.dbcon.showIO;


/**
 * Servlet implementation class studentOperationServlet
 */
@WebServlet("/student_UpdateServlet")
public class student_UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_UpdateServlet() {
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
		
		
		String sex = request.getParameter("stu_sex");
		String age = request.getParameter("stu_age");
		String email = request.getParameter("stu_email");
		String tel = request.getParameter("stu_tel");
		String ID = request.getParameter("stu_IDnumber");
		String intro = request.getParameter("stu_infor");
		String accountID = request.getParameter("stu_id");
		System.out.println(accountID);
		
		String opereation = "Student"+accountID+" modify his or her information with sex"+sex+",age"+age+" email"+email+" tel"+tel+" ID"+ID+" introduction"+intro;
		showIO.writeHistory (opereation);

		
		PersonalFileService personalFileService = new PersonalFileServiceImpl();
		personalFileService.personalFileUpdate(accountID,sex,tel,ID,email, age, intro);
		
		
		doGet(request, response);
		
		
	}

}

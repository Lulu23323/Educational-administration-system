package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.showIO;
import com.dbcon.DBUtility;
import com.dbpool.DBConnection;
//import com.dbpool.LoginTo;

/**
 * Servlet implementation class stLogInServlet
 */
@WebServlet("/stLogInServlet")
public class stLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stLogInServlet() {
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
		
		
		

		
		List<String> names = DBUtility.getElementArray("Account");
        List<String> passwords = DBUtility.getElementArray("Password");

		
		String account = request.getParameter("Account");
		String password = request.getParameter("Password");
		
		
		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		String judge = "";
		int index = -1;
		
		if (!names.contains(account)) {
			System.out.println("ID is wrong");
			judge = "2";
		} else {
	        for (int i = 0; i < names.size(); i++) {
	            if (account.equals(names.get(i))) {
	                index = i;
	            }
	        }
	        if ( password.equals(passwords.get(index)) ) {
	        	System.out.println("success");
				judge = "0";
				String opereation = "Student "+account+" login";		
				showIO.writeHistory (opereation);
	        } else {
	        	System.out.println("ID or password is wrong");
	        	judge = "1";
	        }
		}
		System.out.println(judge);
		response.getWriter().append(judge);
		

	}


    
}

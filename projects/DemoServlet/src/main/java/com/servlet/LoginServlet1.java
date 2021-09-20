package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet1 extends HttpServlet {
	
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
		    String Empnames=request.getParameter("Empname");
		    if(Validate.checkUser(Empnames)) {
		    	RequestDispatcher rd=request.getRequestDispatcher("Welcome");
		    	rd.forward(request, response);
		    }else {
		    	writer.println("Empid is incorrect");
		    	RequestDispatcher rd=request.getRequestDispatcher("login.html");
		    	rd.include(request, response);
		    	
		    }	       
		}


}
}

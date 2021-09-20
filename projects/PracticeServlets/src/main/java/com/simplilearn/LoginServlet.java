package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
			Cookie cookie1=new Cookie("username",username);
			cookie1.setMaxAge(24*60*60);
			Cookie cookie2=new Cookie("password", password);
			cookie2.setMaxAge(24*60*60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			pw.println("<a href='Welcome?username="+username+"'>Home</a>");
//     		RequestDispatcher rd = request.getRequestDispatcher("Welcome");
//			rd.forward(request, response);
		} else {
			pw.println("you are not authroized");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}

	}

}

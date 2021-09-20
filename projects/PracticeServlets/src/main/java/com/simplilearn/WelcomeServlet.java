package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Hey user Welcome to servlets");
		Cookie[]cookie=request.getCookies();
		for(Cookie cookies:cookie) {
			System.out.println(cookies.getName()+" "+cookies.getValue());
		}
		pw.println("Getting username value from cookie:"+cookie[0].getValue());
		pw.println("Getting password value from cookie:"+cookie[1].getValue());
		
	      String Uname=request.getParameter("username");
	      pw.println("Displaying value from URL param:"+Uname);
	      
	      String value=request.getParameter("company");
	      pw.println("Getting the information from hidden field company:"+value);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}

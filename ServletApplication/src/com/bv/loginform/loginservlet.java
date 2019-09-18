package com.bv.loginform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String n = "Hello John";
		 HttpSession session=request.getSession();  
	     session.setAttribute("uname",n);  
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		RequestDispatcher rd;
		PrintWriter pw = response.getWriter();
		
		if(loginDao.validateUser(username, password))
		{
			pw.print("Login Successful");
			rd = request.getRequestDispatcher("products.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("Invalid Credential");	
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

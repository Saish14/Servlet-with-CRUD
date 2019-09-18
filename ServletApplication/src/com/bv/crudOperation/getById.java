package com.bv.crudOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bv.handler.ProductDBHandler;
import com.bv.model.Products;

/**
 * Servlet implementation class getById
 */
@WebServlet("/getById")
public class getById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.print(n);
		
		int id = Integer.parseInt(request.getParameter("id"));

		Products list = ProductDBHandler.getProductById(id);
		out.print("<h4>Product Details</h4>");
		out.print(
				"<table border='5' align='center' color=''><tr><td>ID</td><td>PRODUCTNAME</td><td>MANUFACTURERNAME</td><td>PRICE</td></tr>");

		int id1 = list.getId();
		String productname = list.getProductname();
		String manufacturername = list.getManufacturername();
		double price = list.getPrice();

		out.print("<tr><td>" + id1 + "</td>");
		out.print("<td>" + productname + "</td>");
		out.print("<td>" + manufacturername + "</td>");
		out.print("<td>" + price + "</td>");
		out.print("<td><a href= \" products.html\">Update</a></td>");
		out.print("<td><a href= \" delete.html\">Delete</a></td></tr>");
		out.print("</table>");
		out.print("<a href='products.html' style='float: right;'>Home</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

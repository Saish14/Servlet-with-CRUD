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
 * Servlet implementation class Deleteproduct
 */
@WebServlet("/Deleteproduct")
public class Deleteproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();

        HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
         pw.print(n);
			
		int id = Integer.parseInt(request.getParameter("id"));

       Products product = new Products();
        ProductDBHandler.DeleteProducts(id);
       // response.sendRedirect("list");
        pw.print("Deleted Successfully");
        
        pw.print("<a href = 'ViewProduct.jsp'>VIEW PRODUCT</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

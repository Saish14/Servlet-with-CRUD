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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
         out.print(n);
		  
        int id=Integer.parseInt(request.getParameter("id"));  
        String productname=request.getParameter("productname"); 
		String manufacturername=request.getParameter("manufacturername");
		String price =request.getParameter("price");
		Products products =new Products();
		
		products.setId(id);
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(Double.parseDouble(price));
		
		int status=ProductDBHandler.UpdateProducts(products);
				if(status>0)
				{
					out.print("<h2>Records Updated Successfully!!!</h2>");
					response.sendRedirect("ViewProduct.jsp");
				}
				else
				{
					out.print("Error! in Updating the Product");
				}
		
				out.print("<a href='products.html'>Products</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

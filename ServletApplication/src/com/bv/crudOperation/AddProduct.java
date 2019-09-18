package com.bv.crudOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.handler.ProductDBHandler;
import com.bv.model.Products;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String productname = request.getParameter("productname");
		String manufacturername = request.getParameter("manufacturername");
		String price = request.getParameter("price");
		
		Products products = new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(Double.parseDouble(price));
		
		int status = ProductDBHandler.addProducts(products);
		if(status>0)
		{
			pw.print("<h2>Records inserted successfully!!!</h2>");
			 pw.print("<a href = 'ViewProduct.jsp'>VIEW PRODUCT</a>");
		}
		else
		{
			pw.print("Error! in inserting the records");
		}
	    // pw.print("< a href = 'ViewProduct.jsp'>View Product</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

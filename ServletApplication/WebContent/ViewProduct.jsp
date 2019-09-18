<%@page import="com.bv.handler.ProductDBHandler"%>
  <%@page import = "com.bv.model.Products" %>
  <%@page import="java.util.ArrayList"%>
 <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Products</title>
</head>
<body>
<h1>List of All Products</h1>
<a href="products.html">Add Products</a>
<% List<Products> list=ProductDBHandler.getAllProducts(); %>
<table border='1'>
<tr><th>Id</th>
<th>Product Name</th>
<th>Manufacturer Name</th>
<th>Price</th>
<th>Update</th>
<th>Delete</th>
</tr>
<% for(Products prd:list)
{
%>
<tr>
<td><%=prd.getId()%></td>
<td><%=prd.getProductname()%></td>
<td><%=prd.getManufacturername()%></td>
<td><%=prd.getPrice()%></td>

 <td><a href='Delete.html'>Delete</a></td>

<td><a href='update.jsp?id=<%= prd.getId() %>'>Update</a></td>

</tr>
<%} %>
</table>
</body>
</html>
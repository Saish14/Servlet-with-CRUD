<%@page import="com.bv.model.Products"%>
<%@page import="com.bv.handler.ProductDBHandler"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Products</title>
</head>
<%
		String pid = request.getParameter("id");
		int id = Integer.parseInt(pid);
		Products products = ProductDBHandler.getProductById(id);
		System.out.println(products.getId()+" "+products.getProductname()+" "+products.getPrice());
	%>
<body>
	<h1>Update Products</h1>
	
	<form action="UpdateProduct">
		<table>
			<tr>
				<td></td>
				<td><input type='hidden' name="id"
					value="<%=products.getId()%>" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="productname"
					value="<%=products.getProductname()%>" /></td>
			</tr>
			<tr>
				<td>Manufacturer Name: <select name="manufacturername"
					style="width: 150px">
						<option value="Samsung">Samsung</option>
						<option value="Oppo">Oppo</option>
						<option value="Vivo">Vivo</option>
						<option value="IPhone">IPhone</option>
						<option value="MI">MI</option>
						<option value="Others">Others</option>
				</select>
			<tr>
				<td>Price:</td>
				<td><input type="number" name="price"
					value="<%=products.getPrice()%>" /></td>
			</tr>
			<tr>
				<td><input type='submit' value='Update' /></td>
			</tr>
		</table>
	</form>
</body>
</html>
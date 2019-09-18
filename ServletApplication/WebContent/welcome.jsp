<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String name=request.getParameter("username");  
out.print("welcome to our bank "+name);  
%> 
<br>
<a href = "index.html">HOME</a>
</body>
</html>
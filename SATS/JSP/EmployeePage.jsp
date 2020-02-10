<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Success</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>

<body>
<%
HttpSession session1 = request.getSession(false);
if(session.getAttribute("loggedInId") == null){
	
	response.sendRedirect("index.jsp");		
}

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

%>
<ul>
  <li><a href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a class="active" href="LogoutServlet">Logout</a></li>
</ul>
<h1>Welcome <%= session.getAttribute("loggedInId") %></h1> 
<p>To submit a module click on the module name</p>
<form action="SubmitModuleServlet">
<table border="2">
  <tr>
  	<th>Project Code</th>
  	<th>Start Date</th>
  	<th>Module Name</th>
  	<th>End Date</th>  	
  </tr>
  <c:forEach items="${emps }" var="l">
  	<tr>
  		<td>${l.getProjectCode() }</td>
  		<td>${l.getStartDate() }</td>  		
  		<td><input type="submit" value="${l.getModuleName() }" name="moduleName" ></input></td>
  		<td>${l.getEndDate() }</td>  		
  	</tr>
  </c:forEach>
</table>
</form>
</body>
</html>
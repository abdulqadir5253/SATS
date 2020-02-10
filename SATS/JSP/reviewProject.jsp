<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Review Project</title>
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
</style>
</head>
<body>
<h1><center>Review Project <%request.getParameter("projectCode"); %></center></h1>
<table border="2">
  <tr>
  	<th>Employee Id</th>
  	<th>Module Name</th>
  	<th>Assigned Date</th>
  	<th>Submitted Date</th>  	
  </tr>
  <c:forEach items="${info }" var="l">
  	<tr>  		
  		<td>${l.getEmpid() }</td>
  		<td>${l.getModuleName() }</td>
  		<td>${l.getAssignedDate() }</td>
  		<td>${l.getSubmittedDate() }</td>  		
  	</tr>
  </c:forEach>
</table>
</body>
</html>
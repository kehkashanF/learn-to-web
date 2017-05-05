<%@page import="model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--<%	
	Employee e=new Employee();
		e.setEmpId(10);
		e.setName("Kehkashan");
		out.println(e);
		%>  -->	
		
	<jsp:useBean id="emp" class="model.Employee" ></jsp:useBean>
	<jsp:setProperty property="empId" name="emp" value="102"/>
	<jsp:setProperty property="name" name="emp" value="ABC"/>
	<jsp:getProperty property="empId" name="emp"/>
	<jsp:getProperty property="name" name="emp"/>
	
</body>
</html>
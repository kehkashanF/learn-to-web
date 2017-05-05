<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="IncludedJSP.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
			String s;
			int m1(){
				return 10;
			}
	%>
	
	<%
		s="Hello World";
		a=30;
		Date date=new Date();
		out.println("Using out in JSP!<br/>");
	%>
	
	<%= "a : "+a %><br/>
	<%= m1()%><br/>
	<%= "s is "+s%><br/>
	<%=date %><br/>
</body>
</html>
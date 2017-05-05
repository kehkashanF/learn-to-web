<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">ALL USER LIST IS AS BELOW</h1>
	<table align="center" border="1">
		<tr>
			<th>Sr. No.</th>
			<th>FName</th>
			<th>LName</th>
			<th>Email</th>
			<th></th>
		</tr>
		
		<c:forEach var="val" items="${list}" varStatus="st">
		<tr>
			<td><c:out value="${st.count}" /></td>
			<td><c:out value="${val.firstName}" /></td>
			<td><c:out value="${val.lastName}" /></td>
			<td><c:out value="${val.email}" /></td>
			<td><a href="deleteIt.htm">Delete</a></td>
		</tr>
		</c:forEach>
	
	</table>
</body>
</html>
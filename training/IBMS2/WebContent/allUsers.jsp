<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">All user list is as below</h1>
<table align="center" border="1">
<tr>
<td>Sr. no</td>
<td>FirstName</td>
<td>LastName</td>
<td> email</td>
</tr>
<c:forEach var="val" items="${myusers}" varStatus="st">
<tr>
<td><c:out value="${st.count} "/></td>
<td><c:out value="${val.firstName}" /></td>
<td><c:out value="${val.lastName}" /></td>
<td><c:out value="${val.email}" /></td>

</tr>
</c:forEach>






</table> 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form  modelAttribute="user" method="POST" action="add.htm">
				<h2><center>USER REG</center></h2> 
				
				<table>
					<tr>
							<td width="50%" align="right">FIRST NAME</td>
							<td width="50%" align="left"> 
							<form:input path="firstName" size="30"/>
							<font color="red"><form:errors path="firstName"/></font>
							</td>
							
					</tr>
					<tr>
							<td width="50%" align="right">LAST NAME</td>
							<td width="50%" align="left"> <form:input path="lastName" size="30"/>
							<font color="red"><form:errors path="lastName"/></font>
							</td>
								
					</tr>
					<tr>
							<td width="50%" align="right">GENDER</td>
							<td width="50%" align="left"> 
								<form:select path="gender">
									<form:options items="${genderList}" itemValue="id" itemLabel="value"/>
								</form:select>
							</td>
					</tr>
					<tr>
							<td width="50%" align="right">ADDRESS</td>
							<td width="50%" align="left"> <form:input path="address" size="30"/>
							<font color="red"><form:errors path="address"/></font>
							</td>
								
					</tr>
					<tr>
							<td width="50%" align="right">EMAIL</td>
							<td width="50%" align="left"> <form:input path="email" size="30"/>
							<font color="red"><form:errors path="email"/></font>
							</td>
							
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="CLICK ON ME"></td>
					</tr>
				</table>
			
		</form:form>
</body>
</html>
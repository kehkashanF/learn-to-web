<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Password - IBMS</title>
<style type="text/css">
	.error-password {
	color: #FF0000;
	display: none;
	}
</style>

</head>
<body>
	<%
		if(request.getParameter("status").equals("no"))
		{
	%>
		<label style="color:red">Incorrect Password! Try again</label>
	<%
		}
	%>
	<form action="EditPasswordServlet" method="post">
		Enter old password: <input type="password" name="oldPassword">
		Enter new password: <input type="password" name="newPassword" id="np1">
		Re-enter new password: <input type="password" name="tpPassword" id="np2" onblur="checkEqual();">
		<label id="l1" class="error-password">Passwords do not match!</label>
	</form>
	<script type="text/javascript">
	
	function confirmPassword() {
		var pwd1 = document.getElementById("pwd1").value;
		var pwd2 = document.getElementById("pwd2").value;
		if (pwd1 === pwd2) {
			document.getElementById("l1").style.display = "none";

		} else {
			document.getElementById("l1").style.display = "inline";

		}
	}

	</script>
</body>
</html>
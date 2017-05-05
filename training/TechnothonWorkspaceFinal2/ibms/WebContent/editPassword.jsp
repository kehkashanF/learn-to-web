<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.bean.Hospital"%>
<%@page import="com.bean.BloodBank"%>
<html>
<head>
<title></title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Squada+One'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Source+Sans+Pro:400,200,300,600,700,900'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- //end-smoth-scrolling -->
<style type="text/css">
.error-password {
	color: #FF0000;
	display: none;
}
</style>
</head>
<body>
	<!--banner start here-->
	<div class="banner-two">
		<div class="header">
			<div class="container">
				<div class="header-main">
					<div class="logo">
						<h1>
							<a href=""> IBMS Connect</a>
						</h1>
					</div>
					<div class="top-nav">
						<span class="menu"> <img src="images/icon.png" alt="" /></span>
						<nav class="cl-effect-1">
							<ul class="res">
<!-- 								<li><a href="index.html">Home</a></li> -->
<!-- 								<li><a class="active" href="about.html">About</a></li> -->
<!-- 								<li><a href="services.html">Services</a></li> -->
<!-- 								<li><a href="gallery.html">Gallery</a></li> -->
<!-- 								<li><a href="shortcords.html">Short Codes</a></li> -->
<!-- 								<li><a href="contact.html">Contact</a></li> -->
<!-- 							</ul> -->
							<li>Welcome <%
								
								
									if (request.getSession(false) == null) {
										//redirect to login page 
										//alert please login
									response.sendRedirect("loginFirst.jsp");

									} else {
										BloodBank bloodBank = (BloodBank) session
												.getAttribute("bloodbank");
										Hospital hospital = (Hospital) session.getAttribute("hospital");

										if (bloodBank == null && hospital == null) {
											//redirect to login page 
											//alert please login
										} else {
											String name = "name";
											if (bloodBank != null) {
												name = bloodBank.getBloodBank_name();
											} else if (hospital != null) {
												name = hospital.getHospital_name();
											}
								%> <%=name%> <%
 	}

 	}
 %></li>
								<li><a class="active" href="about.html">About</a></li>
								<li>Emergency Contact: +91 (712) 66 92084</li>
								<li>
									<form action="LogoutServlet" method="post">
										<input type="submit" class="btn btn-1 btn-primary"
											value="Logout" id="logout" name="logout">
									</form>
								</li>
							
							
							</ul>
						</nav>
						<!-- script-for-menu -->
						<script>
							$("span.menu").click(function() {
								$("ul.res").slideToggle(300, function() {
									// Animation complete.
								});
							});
						</script>
						<!-- /script-for-menu -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--banner end here-->
	<!--about start here-->
	<div class="about">
		<div class="container">
			<div class="about-main">
				<div class="about-top">
					<h2>Password Reset Success!!</h2>
					<h1>
						You password has been reset successfully. <a href="login.jsp">Click
							here</a> to Login.
					</h1>

					<%
						if (request.getParameter("type").equals("bb")) {
					%>
					<!-- 					<form action="EditPasswordBB" method="post"> -->
					<!-- 						Enter old password: <input type="password" name="oldPassword"> -->
					<!-- 						Enter new password: <input type="password" name="newPassword" -->
					<!-- 							id="np1"> Re-enter new password: <input type="password" -->
					<!-- 							name="tpPassword" id="np2" onblur="checkEqual()"> <label -->
					<!-- 							id="l1" class="error-password">Passwords do not match!</label> <input -->
					<!-- 							type="submit" name="Submit"> -->
					<!-- 					</form> -->
					<div class="form-group">




						<form action="EditPasswordBB" method="post">
							<table align=center>
								<tr>
									<td><label class="sr-only" for="exampleInputEmail3">Enter
											current password:</label> Enter current password:</td>
									<td><input type="password" name="oldPassword"
										class="form-control" placeholder="Current Password"
										style="width: 300px;"></td>
								</tr>

								<tr>

									<td><label class="sr-only" for="exampleInputEmail3">Enter
											new password:</label> Enter new password:</td>
									<td><input type="password" name="newPassword" id="np1"
										class="form-control" placeholder="New Password"></td>
								</tr>

								<tr>

									<td><label class="sr-only" for="exampleInputEmail3">Re-enter
											new password:</label> Re-enter new password:</td>
									<td><input type="password" name="tpPassword" id="np2"
										onblur="checkEqual()" class="form-control"
										placeholder="Re-enter password"> <label id="l1"
										class="error-password">Passwords do not match!</label></td>
								</tr>
							</table>
						</form>

					</div>

					<%
						} else {
					%>
					<!-- 					<form action="EditPasswordServlet" method="post"> -->
					<!-- 						Enter old password: <input type="password" name="oldPassword"> -->
					<!-- 						Enter new password: <input type="password" name="newPassword" -->
					<!-- 							id="np1"> Re-enter new password: <input type="password" -->
					<!-- 							name="tpPassword" id="np2" onmouseout="checkEqual()"> <label -->
					<!-- 							id="l1" class="error-password">Passwords do not match!</label> <input -->
					<!-- 							type="submit" name="Submit"> -->
					<!-- 					</form> -->
					<div class="form-group">




						<form action="EditPasswordBB" method="post">
							<table align=center>
								<tr>
									<td><label class="sr-only" for="exampleInputEmail3">Enter
											current password:</label> Enter current password:</td>
									<td><input type="password" name="oldPassword"
										class="form-control" placeholder="Current Password"
										style="width: 300px;"></td>
								</tr>

								<tr>

									<td><label class="sr-only" for="exampleInputEmail3">Enter
											new password:</label> Enter new password:</td>
									<td><input type="password" name="newPassword" id="np1"
										class="form-control" placeholder="New Password"></td>
								</tr>

								<tr>

									<td><label class="sr-only" for="exampleInputEmail3">Re-enter
											new password:</label> Re-enter new password:</td>
									<td><input type="password" name="tpPassword" id="np2"
										onblur="checkEqual()" class="form-control"
										placeholder="Re-enter password"> <label id="l1"
										class="error-password">Passwords do not match!</label></td>
								</tr>
							</table>
						</form>

					</div>
					<%
						}
					%>
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




				</div>

			</div>
		</div>
	</div>


</body>
</html>
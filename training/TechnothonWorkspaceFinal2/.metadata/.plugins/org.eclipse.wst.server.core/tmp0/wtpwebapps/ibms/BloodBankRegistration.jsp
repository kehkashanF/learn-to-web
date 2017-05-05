<!DOCTYPE HTML>
<%@page import="java.util.List"%>
<html>
<head>
<title>Connect</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="">
<script>	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Squada+One'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Source+Sans+Pro:400,200,300,600,700,900'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->


<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script src="js/BloodBankValidation.js"> 
</script>

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
#center {
	margin-left: 50px;
}

.my-error-class {
	color: #FF0000; /* red */
	display: inline;
}

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
<!-- 							<ul class="res"> -->
<!-- 								<li><a href="index.html">Home</a></li> -->
<!-- 								<li><a class="active" href="about.html">About</a></li> -->
<!-- 								<li><a href="services.html">Services</a></li> -->
<!-- 								<li><a href="gallery.html">Gallery</a></li> -->
<!-- 								<li><a href="shortcords.html">Short Codes</a></li> -->
<!-- 								<li><a href="contact.html">Contact</a></li> -->
<!-- 							</ul> -->
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
	<div id="center">
		<!-- ----------------------------------- -->

		<br>

		<div class="form-group">
		
			<form action="BBRegisterValidationController" method="post"
				id="register-form">
				<p class="instruction">*All Fields are mandatory</a>
				<table align=center>
					<tr>
					<div class="form-group">
						<td><label class="sr-only" for="exampleInputEmail3">Blood
								Bank Name:</label> Blood Bank Name:</td>
						<td><input type="text" class="form-control" id="bName"
							placeholder="Blood Bank's Name" style="width: 300px;"
							name="bName"></td>
						</div>
					</tr>

					<tr>

						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Email:</label>
								Email:</td>
							<td><input type="email" class="form-control" id="email"
								placeholder="Email" name="email"></td>
						</div>
					</tr>

					<tr>

						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Password:</label>
								Password:</td>
							<td><input type="password" class="form-control" id="pwd1"
								placeholder="password" name="password"></td>
						</div>
					</tr>

					<tr>

						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Re-enter
									Password: </label> Re-enter Password:</td>
							<td><input type="password" class="form-control" id="pwd2"
								name="password1" onblur="confirmPassword();"
								placeholder="Password"><label id="l1" for="pwd2"
								class="error-password">Passwords do not match!</label></td>
						</div>
					</tr>

					<tr>
					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">B.T.O's
									Name: </label> B.T.O's Name:</td>
							<td><input type="text" class="form-control" id="btoName1"
								name="btoName" placeholder="B.T.O's Name"></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Contact
									No.: </label> Contact No.:</td>
							<td><input type="number" class="form-control" id="contact1"
								name="contact" placeholder="Contact"></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">License
									No.: </label> License No.:</td>
							<td><input type="text" class="form-control" id="lNum1"
								name="lNum" placeholder="License No."></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Circle:
							</label> Circle:</td>
							<td><input type="text" class="form-control" id="circle1"
								name="circle" placeholder="Circle"></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Address:
							</label> Address:</td>
							<td><textarea rows="4" cols="6" class="form-control"
									id="address1" placeholder="Address" name="address"> </textarea></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Pincode:
							</label> Pincode:</td>
							<td><input type="text" class="form-control" id="pincode1"
								name="pincode" placeholder="Pincode"></td>
						</div>
					</tr>

					<tr>
						<div class="form-group">
							<td><label class="sr-only" for="exampleInputEmail3">Functional:
							</label> Functional:</td>
							<!--     <td>    <input type="radio" name = "func" class="form-control" id="func11" placeholder="Functional1" value="YES" checked ></td> -->
							<!--      <td>    <input type="radio" name = "func" class="form-control" id="func11" placeholder="Functional1" value="NO"></td> -->
							<td><INPUT TYPE="radio" NAME="func" VALUE="radio1" CHECKED>
								YES <BR> <INPUT TYPE="radio" NAME="func" VALUE="radio2">
								NO <BR></td>
						</div>
					</tr>

					<td>
						<button type="submit" class="btn btn-default">Submit</button>
					</td>

				</table>
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

		</div>

	</div>
	<!--about end here-->

</body>
<%
	List<String> errorMessages = (List<String>) session
			.getAttribute("errorMessages");
	if (errorMessages != null) {
		for (String s : errorMessages) {
			out.println("<BR>");
			out.println(s);
		}
	}
%>

</html>
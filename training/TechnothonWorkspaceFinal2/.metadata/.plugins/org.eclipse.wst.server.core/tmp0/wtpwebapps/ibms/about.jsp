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
<title>IBMS</title>
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
							<ul class="res mainmenu1">
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
					<h2>About</h2>
					<h1>"Gift of blood is Gift of life."</h1>
				</div>
				<div class="about-bottom">
					<div class="col-md-6 ab-left">
						<h4>Integrated Blood Management System</h4>
						<p>Indian medical system faces a problem of decentralized
							blood banks with the process for acquiring blood differing at
							each blood bank, with almost all the interaction happening
							between the patient and blood bank. We provide an interface that
							connects hospitals to blood banks, accelerating the process of
							procuring blood by the hospitals, hence eliminating the
							patient’s role, making his/her life easier.</p>
					</div>
					<div class="col-md-6 ab-right">
						<!-- 					<a href="single.html"><img src="images/ab.jpg" alt="" class="img-responsive"></a> -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="staff">
		<div class="container">
			<div class="staff-main">
				<div class="staff-top">
					<h3>Our Team</h3>
				</div>
				<div class="staff-bottom">
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t1.jpg" alt="" class="img-responsive"> -->
						<h4>Abhilasha Sharma</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t2.jpg" alt="" class="img-responsive"> -->
						<h4>Ankita Agrawal</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t3.jpg" alt="" class="img-responsive"> -->
						<h4>Baha Aiman</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t4.jpg" alt="" class="img-responsive"> -->
						<h4>Kehkashan Fazal</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t4.jpg" alt="" class="img-responsive"> -->
						<h4>Navneet Bhatia</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t4.jpg" alt="" class="img-responsive"> -->
						<h4>Poulami Roychoudhary</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="col-md-3 staff-grid">
						<!-- 					<img src="images/t4.jpg" alt="" class="img-responsive"> -->
						<h4>Snehal Gabhane</h4>
						<p>Software Engineer,Persistent Systems Limited</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="we-do">
		<div class="container">
			<div class="we-do-main">
				<div class="we-do-top">
					<h3>What We Do</h3>
					<p>Integrated Blood Management System (IBMS) manages requests
						raised by the hospitals by finding the nearest possible blood bank
						that can fulfill the requirement of blood. We also aim to
						regularize the entire process from the pickup of the patient’s
						blood sample to the final delivery.</p>

				</div>
			</div>
		</div>
	</div>
	<!--about end here-->
	
</body>
</html>
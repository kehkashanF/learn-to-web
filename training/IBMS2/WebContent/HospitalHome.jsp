<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.bean.Request"%>
<%@page import="com.bean.Hospital"%>
<%@page import="com.dao.HospitalDAOImpl_template"%>
<%@page import="com.bean.BloodBank"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Civil Engineer A industrial category Flat bootstrap
	Responsive Website Template | About :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Civil Engineer Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
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
</head>
<body>
	<!--banner start here-->
	<div class="banner-two">
		<div class="header">
			<div class="container">
				<div class="header-main">
					<div class="logo">
						<h1>
							<a href="index.html">Civil Engineer</a>
						</h1>
					</div>
					<div class="top-nav">
						<span class="menu"> <img src="images/icon.png" alt="" /></span>
						<nav class="cl-effect-1">
							<ul class="res">
								<li><a href="index.html">Home</a></li>
								<li><a class="active" href="about.html">About</a></li>
								<li><a href="services.html">Services</a></li>
								<li><a href="gallery.html">Gallery</a></li>
								<li><a href="shortcords.html">Short Codes</a></li>
								<li><a href="contact.html">Contact</a></li>
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






	<div class="we-do">
		<div class="container">
			<div class="page-header">
				<nav id="menu">

					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active" id="listBanks"><a
							onclick="return theFunction();" >List Bloodbanks</a></li>
						<li role="presentation" id="edit"><a href="EditDetails.jsp" >Edit
								details</a></li>
						<li role="presentation" id="request"><a href="requestForm.jsp" >Request
								Blood</a></li>
						<li role="presentation" id="cancelreqtab"><a onclick="return cancelFunction();" >Cancel
								Requests</a></li>
					</ul>
				</nav>
				

				<script type="text/javascript">
					function theFunction() {
						document.getElementById("cancelreqtab").setAttribute("class", "passive");
						document.getElementById("edit").setAttribute("class", "passive");
						document.getElementById("request").setAttribute("class", "passive");
						document.getElementById("listBanks").setAttribute("class", "active");
						document.getElementById("listAllBB").style.display = "block";
					}
					function cancelFunction() {
						document.getElementById("cancelreqtab").setAttribute("class", "active");
						document.getElementById("edit").setAttribute("class", "passive");
						document.getElementById("request").setAttribute("class", "passive");
						document.getElementById("listBanks").setAttribute("class", "passive");
						document.getElementById("cancelRequest").style.display ="block";
					}
				</script>

				<div id="listAllBB" style="display: none">
					<h2>All Bloodbanks</h2>
					<p>
					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Bloodbank Name</th>
									<th>Address</th>
									<th colspan="2">Contact No.</th>
								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>

									<%
										List<BloodBank> bbs = (new HospitalDAOImpl_template()).getAllBloodbanks();
																	if(bbs != null)
																	for (BloodBank b : bbs) {
									%>
									<td><a href=""><%=b.getBloodBank_name()%> </a></td>
									<td><%=b.getBloodBank_address()%></td>
									<td><%=b.getBloodBank_telephoneNo()%></td>
									<td><%=b.getBloodBank_mobileNo()%></td>

									<%
										}
									%>

								</tr>

							</tbody>
						</table>
					</div>



					</p>
				</div>
				<div id="cancelRequest" style="display: none">
					<!-- <details>
						<summary>Get Details -->
					<p>
					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Request ID</th>
									<th>Patient's Name</th>
									<th>Blood Bank</th>
									<th>Quantity</th>
									<th>Delivery Date And Time</th>

								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>

									<%
// 										Hospital hospital=(Hospital) session.getAttribute("hospital");
									Hospital hospital = new Hospital("hospital_name", "hospital_address",
											440067, "hospital_password", "hospital_lisenceNo",
											"officer_name", "hospital_email", "hospital_certification",
											"hospital_contactNo");
									List<Request> requests = (new HospitalDAOImpl_template()).seeAllRequests(hospital);
																											 							for (Request req : requests) {
									%>
									<td><Details>
											<summary><%=req.getRequestId()%>
											</summary>
											<p>
												Doctor's Name :
												<%=req.getDoctor_name()%>
												<br> Blood Type :
												<%=req.getBloodType()%>
												<br> Status :
												<%=req.getStatus()%>
												<br>
											</p>


										</Details></td>
									<td><%=req.getPatient_name()%> </a></td>
									<td><%=req.getBloodBank()%></td>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getDelivery_date_time()%></td>
									<td><input type="button" name="Cancel_Request" value="Cancel Request" onclick="<% new HospitalDAOImpl_template().cancelRequest(req); %>"></td>
									<%
										}
									%>

								</tr>

							</tbody>
						</table>
					</div>



					</p>



				</div>
				<div class="footer">
					<div class="container">
						<div class="footer-main">
							<div class="col-md-4 ftr-gd">
								<h3>Follow Us</h3>
								<ul>
									<li><a href="#" class="fa"> </a></li>
									<li><a href="#" class="tw"> </a></li>
									<li><a href="#" class="g"> </a></li>
								</ul>
							</div>
							<div class="col-md-4 ftr-gd">
								<h3>Newsletter</h3>
								<form>
									<input type="text" value="Enter Your email"
										onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Enter Your email';}">
									<input type="submit" value="Subscribe">
								</form>
							</div>
							<div class="col-md-4 ftr-gd">
								<h3>Address</h3>
								<p>59658 officiis debitis</p>
								<p>Cicero, written in BC</p>
								<p>Ph :+1586 8557 455</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="copyright">
							<p>
								© 2015 Civil Engineer. All rights reserved | Design by <a
									href="http://w3layouts.com/" target="_blank"> W3layouts </a>
							</p>
						</div>
						<script type="text/javascript">
							$(document).ready(function() {

								$().UItoTop({
									easingType : 'easeOutQuart'
								});

							});
						</script>
						<a href="#" id="toTop" style="display: block;"> <span
							id="toTopHover" style="opacity: 1;"> </span></a>

					</div>
				</div>
				<!--footer end here-->
</body>
</html>
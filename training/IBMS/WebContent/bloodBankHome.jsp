<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="com.dao.BloodBankDAOImpl"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="com.bean.Request"%>
<%@page import="com.bean.Hospital"%>
<%@page import="com.dao.HospitalDAOImpl"%>
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

<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script src="js/editDetailsValidatebb.js">
	
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

/* .my-valid-class { */
/* 	color: #00CC00; /* green */
* /
	/* } */ 

.error-password {
	color: #FF0000;
	display: none;
}
</style>

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
						<li role="presentation" class="active" id="stock"><a
							onclick="return theFunction();">Stock Available</a></li>
						<li role="presentation" id="editDetails"><a
							onclick="return editFunction();">Edit Details</a></li>
						<li role="presentation" id="pending"><a
							href="requestForm.jsp">Pending Requests</a></li>
						<li role="presentation" id="listDonors"><a
							onclick="return getDonorsFunction();">List Of Donors</a></li>
						<li role="presentation" id="myRequests"><a
							href="MyRequests.jsp">My Requests</a></li>	

					</ul>
				</nav>


				<script type="text/javascript">
					function theFunction() {
						document.getElementById("editDetails").setAttribute(
								"class", "passive");
						document.getElementById("pending").setAttribute(
								"class", "passive");
						document.getElementById("listDonors").setAttribute(
								"class", "passive");
						document.getElementById("stock").setAttribute("class",
								"active");
						document.getElementById("myRequests").setAttribute("class",
						"passive");
						document.getElementById("stock").style.display = "block";
						document.getElementById("listDonors").style.display = "none";
						document.getElementById("listRequests").style.display = "none";
						
					}
					function getDonorsFunction() {
						document.getElementById("editDetails").setAttribute(
								"class", "passive");
						document.getElementById("pending").setAttribute(
								"class", "passive");
						document.getElementById("listDonors").setAttribute(
								"class", "active");
						document.getElementById("stock").setAttribute("class",
								"passive");
						document.getElementById("myRequests").setAttribute("class",
						"passive");

						document.getElementById("listDonors").style.display = "block";
						document.getElementById("stock").style.display = "none";
						document.getElementById("listRequests").style.display = "none";

					}
// 					function getRequestsFunction() {
// 						document.getElementById("editDetails").setAttribute(
// 								"class", "passive");
// 						document.getElementById("pending").setAttribute(
// 								"class", "passive");
// 						document.getElementById("listDonors").setAttribute(
// 								"class", "passive");
// 						document.getElementById("stock").setAttribute("class",
// 								"passive");
// 						document.getElementById("myRequests").setAttribute("class",
// 						"active");
// 						document.getElementById("stock").style.display = "none";
// 						document.getElementById("listDonors").style.display = "none";
// 						document.getElementById("listRequests").style.display = "block";

// 					}
						function editFunction() {
						document.getElementById("editDetails").setAttribute(
 								"class", "active");
 						document.getElementById("pending").setAttribute(
 								"class", "passive");
 						document.getElementById("listDonors").setAttribute(
 								"class", "passive");
 						document.getElementById("stock").setAttribute("class",
 								"passive");
 						document.getElementById("myRequests").setAttribute("class",
 						"passive");
 						
 						document.getElementById("editDetails1").style.display = "block";
					}
			</script>

				<div id="stock" style="display: none">
					<h2>All Bloodbanks</h2>
					<p>
					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Blood Group</th>
									<th>Blood Type</th>
									<th>Units</th>
								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>
									<%
									//get bloodbankid
									BloodBank bloodBank=(BloodBank) session.getAttribute("bloodBank");
										 JSONArray jsonArray = new BloodBankDAOImpl().seeStock(bloodBank.getBloodBank_id());
										for (int i = 0; i < jsonArray.length(); i++) {
											JSONObject jsonObject = (JSONObject) jsonArray.get(i); 
									%>
									<td><%=jsonObject.get("bloodGroup")%></td>
									<td><%=jsonObject.get("bloodType")%></td> 
									<td><%=jsonObject.get("quantity")%></td> 
									<%
										 } 
									%>
								</tr>
							</tbody>
						</table>
					</div>

					</p>
				</div>
				<div id="listDonors" style="display: none">
					<h2>List of Donors</h2>
					<p>
					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th> Name</th>
									<th>Gender</th>
									<th>BloodGroup</th>
									<th>Email-Id</th>
									<th>Contact Number</th>
									<th>Address</th>
								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>
									<%
									bloodBank=(BloodBank) session.getAttribute("bloodBank");
										 jsonArray = new BloodBankDAOImpl().seeDonors(bloodBank.getBloodBank_id());
										for (int i = 0; i < jsonArray.length(); i++) {
											JSONObject jsonObject = (JSONObject) jsonArray.get(i); 
									%>
									 <td><%=jsonObject.get("donorName")%></td>
									<td><%=jsonObject.get("gender")%></td>
									<td><%=jsonObject.get("bloodGroup")%></td>
									<td><%=jsonObject.get("emailId")%></td>
									<td><%=jsonObject.get("contactNo")%></td>
									<td><%=jsonObject.get("donorAddress")%></td> 
									<%
									 	} 
									%>
								</tr>
							</tbody>
						</table>
					</div>

					</p>
				</div>
				
				<form action="EditServlet" method="post"
					id="edit-form">
					<div id="editDetails1" style="display: none">
						<%
							BloodBank b=(BloodBank) session.getAttribute("bloodBank");
						%><table>
							<tr>
								<td>Bank Name:</td>
								<td><%=b.getBloodBank_name()%></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><%=b.getBloodBank_emailId()%></td>
							</tr>
<!-- 							<tr><td>  -->
<!-- 							<a href="editPassword.jsp">Edit Password</a></td></tr>							<tr> -->
							<tr>
								<td>B.T.O's Name:</td>
								<td><%=b.getBTO_name()%></td>
								<td><input type="button" name="change1"
									value="Change BTO" id="change_bto"
									onclick="return changeBTO()"></td>
								<td>

									<div id="ChangeBTO" style="display: none">

										Enter new BTO<input type="text" name="newBTO">

									</div>

								</td>
							</tr>

							<tr>
								<td>Contact no.:</td>
								<td><%=b.getBloodBank_mobileNo()%></td>
								<td><input type="button" name="change2"
									value="Change contact" id="change_con"
									onclick="return changeContact()"></td>
								<td>

									<div id="ChangeContact" style="display: none">

										Enter new Contact<input type="text" name="newContact">
										
									</div>

								</td>
							</tr>
							
														

							<tr>
								<td>License No.:</td>
								<td><%=b.getFDA_lisenceNo()%></td>
							</tr>
							<tr>
								<td>Circle:</td>
								<td><%=b.getBloodBank_circle()%></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><%=b.getBloodBank_address()%></td>
							</tr>
							<tr>
								<td>Pincode:</td>
								<td><%=b.getBloodBank_pin()%></td>
							</tr>
							<tr>
								<td>Functional:</td>
								<td><%=b.isFunctional()%></td>
							</tr>
						</table>
						<input type="submit" name="Change" value="Submit">
					</div>
</form>
					<script type="text/javascript">
					
				function changeBTO() {
					
					document.getElementById("ChangeBTO").style.display = "block";
					document.getElementById("change_bto").style.visibility = "hidden";
				}
				
				function changeContact() {
					
					document.getElementById("ChangeContact").style.display = "block";
					document.getElementById("change_con").style.visibility = "hidden";
				}
				</script>

				
				
				
				
</body>
</html>
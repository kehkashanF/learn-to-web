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
<%@page import="com.dao.BloodBankDAOImpl"%>



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
<script
	src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script
	src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
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
<script src="js/BloodBankHome.js"></script>
</head>
<body>
	<!--banner start here-->
	<div class="banner-two">
		<div class="header">
			<div class="container">
				<div class="header-main">
					<div class="logo">
						<h1>
							<a href="index.html">IBMS Connect</a>
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
						<li role="presentation" class="active" id="stockTab"><a
							onclick="return displayHandle('stockTab','stock');">Stock
								Available</a></li>
						<li role="presentation" id="editDetailsTab"><a
							onclick="return displayHandle('editDetailsTab','editDetails1');">Edit
								Details</a></li>
						<!-- 						<li role="presentation" id="pending"><a -->
						<!-- 							href="requestForm.jsp">Pending Requests</a></li> -->
						<li role="presentation" id="listDonorsTab"><a
							onclick="return displayHandle('listDonorsTab','listDonors');">List
								Of Donors</a></li>
						<li role="presentation" id="myRequests"><a
							onclick="return displayHandle('myReqTab','myReq');">My
								Requests</a></li>

					</ul>
				</nav>
				<div id="myReq">
					<h2>My Requests</h2>
					<p class="instruction">
					<table>
						<tbody>
							<tr>
								<td>Acknowledge</td>
								<td>Press when cross-matching successful</td>
							</tr>
							<tr>
								<td>Deny</td>
								<td>Press when delivery cannot be made due to any reason</td>
							</tr>
						</tbody>
					</table>



					<!-- 		<a href="bloodBankHome.jsp">Home</a> -->

					<p>
					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>

									<th colspan="1">Request ID</th>
									<th colspan="1">Blood Group</th>
									<th colspan="1">Blood Type</th>
									<th colspan="1">Quantity required</th>
									<th>Time of delivery</th>
									<th>Units</th>
									<th>Acknowledge</th>
									<th>Deny</th>
									<!-- 									<th>Dispatch</th> -->

								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>

									<%
										BloodBankDAOImpl bbd = new BloodBankDAOImpl();
										BloodBank bank = (BloodBank) session.getAttribute("bloodBank");
										List<Request> bbs = bbd.seeAllRequests(bank);
										if (bbs != null) {
											for (Request r : bbs) {
												int available = Integer.parseInt(bbd.getUnits(bank,
														r.getBloodgroup(), r.getBloodType()));
												int required = r.getQuantity_required();
									%>
								
								<tr>
									<td><%="REQ" + r.getRequestId()%></td>
									<td><%=r.getBloodgroup()%></td>
									<td><%=r.getBloodType()%></td>
									<td><%=required%></td>
									<td><%=r.getDelivery_date_time()%></td>
									<form action="BloodBankServlet">
										<td><input type="hidden" value="<%=r.getRequestId()%>"
											name="rId"></td>
										<td><%=available%></td>

										<%
											if (r.getStatus() == 1) {
										%>
										<td><input type="submit" name="process"
											value="Acknowledge"></td>
										<td><input type="submit" name="process" value="Deny"></td>



										<%
											} else {
										%>


										<td><input type="submit" name="process"
											value="Acknowledge" disabled="disabled"></td>
										<td><input type="submit" name="process" value="Deny"
											disabled="disabled"></td>

									</form>
								</tr>
								<%
									}
										}
									}
								%>

								</tr>

							</tbody>
						</table>
					</div>



					</p>




				</div>



				<div id="stock">
					<h2>STOCK AVAILABLE</h2>
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

								<%
									//get bloodbankid
									BloodBank bloodBank = (BloodBank) session.getAttribute("bloodBank");
									JSONArray jsonArray = new BloodBankDAOImpl().seeStock(bloodBank
											.getBloodBank_id());
									for (int i = 0; jsonArray != null && i < jsonArray.length(); i++) {
										JSONObject jsonObject = (JSONObject) jsonArray.get(i);
								%>
								<tr class="info">
									<th scope="row"><%=i + 1%></th>
									<td><%=jsonObject.get("bloodGroup")%></td>
									<td><%=jsonObject.get("bloodType")%></td>
									<td><%=jsonObject.get("quantity")%></td>
								</tr>
								<%
									}
								%>

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
									<th>Name</th>
									<th>Gender</th>
									<th>BloodGroup</th>
									<th>Email-Id</th>
									<th>Contact Number</th>
									<th>Address</th>
								</tr>
							</thead>
							<tbody>

								<%
									bloodBank = (BloodBank) session.getAttribute("bloodBank");
									jsonArray = new BloodBankDAOImpl().seeDonors(bloodBank
											.getBloodBank_id());
									for (int i = 0; jsonArray != null && i < jsonArray.length(); i++) {
										JSONObject jsonObject = (JSONObject) jsonArray.get(i);
								%>
								<tr class="info">
									<th scope="row"><%=i + 1%></th>
									<td><%=jsonObject.get("donorName")%></td>
									<td><%=jsonObject.get("gender")%></td>
									<td><%=jsonObject.get("bloodGroup")%></td>
									<td><%=jsonObject.get("emailId")%></td>
									<td><%=jsonObject.get("contactNo")%></td>
									<td><%=jsonObject.get("donorAddress")%></td>
								</tr>
								<%
									}
								%>

							</tbody>
						</table>
					</div>

					</p>
				</div>

				<form action="EditServlet" method="post" id="edit-form">
					<div id="editDetails1" style="display: none">
						<%
							BloodBank b = (BloodBank) session.getAttribute("bloodBank");
						%><table>
							<tr>
								<td>Bank Name:</td>
								<td><%=b.getBloodBank_name()%></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><%=b.getBloodBank_emailId()%></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><a href="editPassword.jsp?type=bb">Edit Password</a></td>
							</tr>
							<tr>
								<td>B.T.O's Name:</td>
								<td><%=b.getBTO_name()%></td>
								<td><input type="button" name="change1" value="Change BTO"
									id="change_bto" onclick="return changeBTO()"></td>
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
</body>
</html>
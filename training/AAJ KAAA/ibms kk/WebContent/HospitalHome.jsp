<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.bean.Request"%>
<%@page import="com.bean.Hospital"%>
<%@page import="com.dao.HospitalDAOImpl"%>
<%@page import="com.bean.BloodBank"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>IBMS</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />



<script type="application/x-javascript">
	

	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 








</script>
<!--Google Fonts-->
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

<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script src="js/RequestForm.js"></script>
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>


<script src="js/editDetailsValidate.js"></script>
<style type="text/css">
#center {
	margin-left: 50px;
}

/* .my-valid-class { */
/* 	color: #00CC00; /* green */

	/* } */         

.error-password {
	color: #FF0000;
	display: none;
}

.my-error-class {
	color: #FF0000; /* red */
	display: inline;
}
</style>
<script src="js/HospitalHome.js"></script>

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
								<li><a href="index.html">Home</a></li>
								<li><a class="active" href="about.jsp">About</a></li>
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
						<li role="presentation" class="active" id="listBanksTab"><a
							onclick="return displayHandle('listBanksTab','listAllBB');">List
								Bloodbanks</a></li>
						<li role="presentation" id="editDetailsTab"><a
							onclick="return displayHandle('editDetailsTab','editDetails');">Edit
								details</a></li>
						<li role="presentation" id="requestBloodTab"><a
							onclick="return displayHandle('requestBloodTab','requestForm');">Request
								Blood</a></li>
						<li role="presentation" id="cancelRequestTab"><a
							onclick="return displayHandle('cancelRequestTab','cancelRequest');">Cancel
								Requests</a></li>
						<li role="presentation" id="viewRequestTab"><a
							onclick="return displayHandle('viewRequestTab','listAllRequests');">My
								Requests</a></li>
					</ul>
				</nav>

			</div>






			<div id="listAllBB">
				<!-- 				style="display: none"> -->
				<h2>BLODDBANKS</h2>
				<p>
				<div class="bs-example" data-example-id="contextual-table"
					style="border: 1px solid #eee">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Bloodbank Name</th>
								<th>Address</th>
								<th>Contact No.</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<BloodBank> bbs = (new HospitalDAOImpl()).getAllBloodbanks();
								int k = 1;
								if (bbs != null && bbs.size() != 0)
									for (BloodBank b : bbs) {
							%>
							<tr class="info">
								<th scope="row"><%=k%></th>


								<td><a href=""><%=b.getBloodBank_name()%> </a></td>
								<td><%=b.getBloodBank_address()%></td>

								<td><%=b.getBloodBank_mobileNo()%></td>


							</tr>

							<%
								k++;
									}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div id="requestForm" style="display: none">
			<p class="instruction">*All Fields are mandatory</a>
				<form id="request-form" name="request" action="RequestSubmission"
					method="post">
					<table align=center>
						<tr>


							<div class="form-group">
								<td>Patient's Name:</td>
								<td><input id="patientName" name="patientname" type="text"
									class="form-control" placeholder="Patient Name"
									style="width: 300px;"></td>
							</div>
						</tr>
						<tr>


							<div class="form-group">
								<td>Doctor's Name:</td>
								<td><input id="doctorName" name="doctorname" type="text"
									class="form-control" placeholder="Doctor Name"
									style="width: 300px;"></td>
							</div>
						</tr>
						<tr>




							<div class="form-group">
								<td>Required Blood Group:</td>
								<td><select name="rbg">
										<option value="default">-Choose-</option>
										<option value="O_POSITIVE">O+</option>
										<option value="O_NEGATIVE">O-</option>
										<option value="A_POSITIVE">A+</option>
										<option value="A_NEGATIVE">A-</option>
										<option value="B_POSITIVE">B+</option>
										<option value="B_NEGATIVE">B-</option>
										<option value="AB_POSITIVE">AB+</option>
										<option value="AB_NEGATIVE">AB-</option>
								</select></td>
							</div>
						</tr>

						<tr>

							<div class="form-group">
								<td>Time of requirement:</td>

								<td><input name="requiredTime" type="date"
									class="form-control" placeholder="Time of requirement"></td>
							</div>
						</tr>

						<tr>
							<div class="form-group">
								<td>Units:</td>
								<td><input id="units" type="number" name="units"
									class="form-control" placeholder="0"></td>
							</div>
						</tr>


						<tr>
							<div class="form-group">
								<td>Type of blood:</td>
								<td><select name="bloodtype">
										<option value="default">-Choose-</option>
										<option value="PRC">PRC</option>
										<option value="PC">PC</option>
										<option value="FFP">FFP</option>
										<option value="WB">Whole Blood</option>
								</select></td>
							</div>
						</tr>


						<td>
							<button type="submit" class="btn btn-default">Submit</button>
						</td>

					</table>
				</form>
				<!-- 				<form id="request-form" name="request" action="RequestSubmission" -->
				<!-- 					method="post"> -->
				<!-- 					<div> -->
				<!-- 						Patient's Name: <input id="patientName" name="patientname" -->
				<!-- 							type="text"> -->
				<!-- 					</div> -->
				<!-- 					<div> -->
				<!-- 						Doctor's Name: <input id="doctorName" name="doctorname" -->
				<!-- 							type="text"> -->
				<!-- 					</div> -->
				<!-- 					<div> -->
				<!-- 						Required Blood Group: <select name="rbg"> -->
				<!-- 							<option value="default">-Choose-</option> -->
				<!-- 							<option value="O_POSITIVE">O+</option> -->
				<!-- 							<option value="O_NEGATIVE">O-</option> -->
				<!-- 							<option value="A_POSITIVE">A+</option> -->
				<!-- 							<option value="A_NEGATIVE">A-</option> -->
				<!-- 							<option value="B_POSITIVE">B+</option> -->
				<!-- 							<option value="B_NEGATIVE">B-</option> -->
				<!-- 							<option value="AB_POSITIVE">AB+</option> -->
				<!-- 							<option value="AB_NEGATIVE">AB-</option> -->
				<!-- 						</select> -->
				<!-- 					</div> -->
				<!-- 					<div> -->
				<!-- 						Time of requirement:<input name="requiredtime" type="date"> -->
				<!-- 					</div> -->
				<!-- 					<div> -->
				<!-- 						Units:<input id="units" type="number" name="units"> -->
				<!-- 					</div> -->
				<!-- 					<div> -->
				<!-- 						Type of blood: <select name="bloodtype"> -->
				<!-- 							<option value="default">-Choose-</option> -->
				<!-- 							<option value="PRC">PRC</option> -->
				<!-- 							<option value="PC">PC</option> -->
				<!-- 							<option value="FFP">FFP</option> -->
				<!-- 							<option value="WB">Whole Blood</option> -->
				<!-- 						</select> -->
				<!-- 					</div> -->
				<!-- 					<input type="submit" value="Submit"> -->
				<!-- 				</form> -->
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
			</div>
			<div id="listAllRequests" style="display: none">
				<section id="container">
					<!-- 					<div class="we-do"> -->
					<!-- 						<div class="container"> -->
					<!-- 							<div class="page-header"> -->
					<nav id="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active" id="allTab"><a
								onclick="return displayHandle('allTab','allRequests');">All</a></li>
							<li role="presentation" id="fulfilledTab"><a
								onclick="return displayHandle('fulfilledTab','fulfilledRequests');">Fulfilled</a></li>
							
							<li role="presentation" id="dispatchedTab"><a
								onclick="return displayHandle('dispatchedTab','dispatchedRequests');">Dispatched</a></li>

							<li role="presentation" id="inprogressTab"><a
								onclick="return displayHandle('inprogressTab','progressRequests');">In
									progress</a></li>
							<li role="presentation" id="cancelledTab"><a
								onclick="return displayHandle('cancelledTab','cancelledRequests');">Cancelled</a></li>
						</ul>
					</nav>

					<!-- 								<section id="content"></section> -->


					<!-- 							</div> -->
					<!-- 						</div> -->
					<!-- 					</div> -->
				</section>
				<div id="allRequests" style="display: none">
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


								<%
									Hospital hospital = (Hospital) session.getAttribute("hospital");

									List<Request> requests = (new HospitalDAOImpl())
											.seeAllRequests(hospital);
									k = 1;
									if (requests != null && requests.size() != 0)
										for (Request req : requests) {
								%>
								<tr class="info">
									<th scope="row"><%=k%></th>
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
									<td><%=req.getPatient_name()%></td>

									<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getDelivery_date_time()%></td>

								</tr>
								<%
									k++;
										}
								%>


							</tbody>
						</table>
					</div>
				</div>

<div id="fulfilledRequests" style="display: none">


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


								<%
									hospital = (Hospital) session.getAttribute("hospital");
									requests = (new HospitalDAOImpl()).seeFulfilledRequests(hospital);
									k = 1;
									if (requests != null && requests.size() != 0)
										for (Request req : requests) {
								%>
								<tr class="info">
									<th scope="row"><%=k%></th>
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
									<td><%=req.getPatient_name()%></td>
									<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getDelivery_date_time()%></td>

								</tr>

								<%
									k++;
										}
								%>

							</tbody>
						</table>
					</div>




				</div>

				<div id="dispatchedRequests" style="display: none">


					<div class="bs-example" data-example-id="contextual-table"
						style="border: 1px solid #eee">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>Request ID</th>
									<th>Patient's Name</th>
									<th>Blood Bank</th>
									<th>Quantity Required</th>
									<th>Quantity Dispatched</th>
									<th>Delivery Date And Time</th>

								</tr>
							</thead>
							<tbody>


								<%
									hospital = (Hospital) session.getAttribute("hospital");
									requests = (new HospitalDAOImpl()).seeDispatchedRequests(hospital);
									k = 1;
									if (requests != null && requests.size() != 0)
										for (Request req : requests) {
								%>
								<tr class="info">
									<th scope="row"><%=k%></th>
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
									<td><%=req.getPatient_name()%></td>
									<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getQuantity_received() %></td>
									<td><%=req.getDelivery_date_time()%></td>

								</tr>

								<%
									k++;
										}
								%>

							</tbody>
						</table>
					</div>




				</div>
				<div id="progressRequests" style="display: none">
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
								<%
									hospital = (Hospital) session.getAttribute("hospital");
									requests = (new HospitalDAOImpl()).seeInProgressRequests(hospital);
									k = 1;
									if (requests != null && requests.size() != 0)
										for (Request req : requests) {
								%>
								<tr class="info">
									<th scope="row"><%=k%></th>
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
									<td><%=req.getPatient_name()%></td>
									<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getDelivery_date_time()%></td>

								</tr>
								<%
									k++;
										}
								%>


							</tbody>
						</table>
					</div>




				</div>
				<div id="cancelledRequests" style="display: none">

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


								<%
									hospital = (Hospital) session.getAttribute("hospital");
									requests = (new HospitalDAOImpl()).seeCancelledRequests(hospital);
									k = 1;
									if (requests != null && requests.size() != 0)
										for (Request req : requests) {
								%><tr class="info">
									<th scope="row"><%=k%></th>
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
									<td><%=req.getPatient_name()%></td>
									<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
									<td><%=req.getQuantity_required()%></td>
									<td><%=req.getDelivery_date_time()%></td>
								</tr>
								<%
									k++;
										}
								%>


							</tbody>
						</table>
					</div>




				</div>

			</div>

			<div id="editDetails" style="display: none">
				<form action="EditDetailsHospitalServlet" method="post"
					id="edit-form">

					<%
						Hospital h = (Hospital) session.getAttribute("hospital");
					%><table>
						<tr>
							<td>Hospital Name:</td>
							<td><%=h.getHospital_name()%></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><%=h.getHospital_email()%></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td> 
								<a href="editPassword.jsp?type=h">Edit Password</a>
							</td>
						</tr>
						<tr>
							<td>Officer's Name:</td>
							<td><%=h.getOfficer_name()%></td>
						</tr>
						<tr>
							<td><input type="button" name="change1"
								value="Change offficer" id="change_off"
								onclick="return changeOfficer()"></td>
							<td>

								<div id="ChangeOfficer" style="display: none">

									Enter new Officer<input type="text" name="newOfficer">

								</div>

							</td>
						</tr>

						<tr>
							<td>Contact No.:</td>
							<td><%=h.getHospital_contactNo()%></td>
							<td><input type="button" name="change2"
								value="Change Contact" id="change_con"
								onclick="return changeContact()"></td>
							<td>

								<div id="ChangeContact" style="display: none">

									Enter new Contact<input type="number" name="newNumber">
									<!-- 									<input type="submit" name="Change"> -->
								</div>

							</td>
						</tr>
						<tr>
							<td>License No.:</td>
							<td><%=h.getHospital_lisenceNo()%></td>
						</tr>
						<tr>
							<td>Certification:</td>
							<td><%=h.getHospital_certification()%></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><%=h.getHospital_address()%></td>
						</tr>
						<tr>
							<td>Pincode:</td>
							<td><%=h.getHospital_pin()%></td>
						</tr>
					</table>
					<input type="submit" name="Change"">

				</form>
			</div>
			<div id="cancelRequest" style="display: none">

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


							<%
								hospital = (Hospital) session.getAttribute("hospital");
								requests = (new HospitalDAOImpl()).seeInProgressRequests(hospital);
								k = 1;
								if (requests != null && requests.size() != 0)
									for (Request req : requests) {
							%>
							<tr class="info">
								<th scope="row"><%=k%></th>
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
								<td><%=req.getPatient_name()%></td>
								<%
										BloodBank bank = req.getBloodBank();
												if (bank != null) {
									%>
									<td><%=bank.getBloodBank_name()%></td>
									<%
										} else {
									%>
									<td>-</td>
									<%
										}
									%>
								<td><%=req.getQuantity_required()%></td>
								<td><%=req.getDelivery_date_time()%></td>

								<td><form action="CancelRequestServlet" method="post">
										<input type="hidden" name="rId" value=<%=req.getRequestId()%>>
										<input type="submit" name="Cancel_Request"
											value="CancelRequest">

									</form></td>
							</tr>
							<%
								k++;
									}
							%>



						</tbody>
					</table>
				</div>
			</div>
		</div>


<script type="text/javascript">

	function getParameterByName(name) {
		name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
				.exec(location.search);
		return results === null ? "" : decodeURIComponent(results[1].replace(
				/\+/g, " "));
	}
	var prodId = getParameterByName('submit');
	if (prodId == null) {

	} else {

	}
	if (prodId != null && prodId=="1") {
		
		alert('Request Submitted');
		displayHandle('requestBloodTab', 'requestForm');
		
	}
	if (prodId != null && prodId.localeCompare("2") == 0) {
		displayHandle('requestBloodTab', 'requestForm');

	}
	if (prodId != null && prodId.localeCompare("3") == 0) {

	displayHandle('editDetailsTab','editDetails')
	}	
	
</script>

	</div>
</body>
</html>
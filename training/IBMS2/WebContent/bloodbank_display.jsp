<%@page import="com.bean.Request"%>
<%@page import="com.dao.HospitalDAOImpl_template"%>
<%@page import="com.bean.BloodBank"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="listAllBB">
		<h2>All Bloodbanks</h2>
		<p>
		<div class="bs-example" data-example-id="contextual-table"
			style="border: 1px solid #eee">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Hospital Name</th>
						<th>Address</th>
						<th colspan="2">Contact No.</th>
					</tr>
				</thead>
				<tbody>
					<tr class="info">
						<th scope="row">1</th>

						<%
							List<BloodBank> bbs = (new HospitalDAOImpl_template())
									.getAllBloodbanks();
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
	
<!-- 	<div id="cancelRequest"> -->
<!-- 		<h3>Your request has been cancelled.</h3> -->
<!-- 		<p> -->
<!-- 		<div class="bs-example" data-example-id="contextual-table" -->
<!-- 			style="border: 1px solid #eee"> -->
<!-- 			<table class="table"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th>#</th> -->
<!-- 						<th>Patient</th> -->
<!-- 						<th>Address</th> -->
<!-- 						<th colspan="2">Contact No.</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<!-- 					<tr class="info"> -->
<!-- 						<th scope="row">1</th> -->

<%-- 						<% --%>
// 							List<Request> requests = (new HospitalDAOImpl_template()).seeAllRequests(hospital);
// 							for (Request req : requests) {
<%-- 						%> --%>
<%-- 						<td><a href=""><%=b.getBloodBank_name()%> </a></td> --%>
<%-- 						<td><%=b.getBloodBank_address()%></td> --%>
<%-- 						<td><%=b.getBloodBank_telephoneNo()%></td> --%>
<%-- 						<td><%=b.getBloodBank_mobileNo()%></td> --%>

<%-- 						<% --%>
// 							}
<%-- 						%> --%>

<!-- 					</tr> -->

<!-- 				</tbody> -->
<!-- 			</table> -->
<!-- 		</div> -->



<!-- 		</p> -->
		
<!-- 	</div> -->


	

</body>
</html>

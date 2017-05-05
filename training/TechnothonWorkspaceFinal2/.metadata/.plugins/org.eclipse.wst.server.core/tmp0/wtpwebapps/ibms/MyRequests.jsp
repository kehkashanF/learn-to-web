<%@page import="com.dao.BloodBankDAOImpl"%>
<%@page import="com.bean.Request"%>
<%@page import="com.dao.HospitalDAOImpl"%>
<%@page import="com.bean.BloodBank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.text.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/ackdeny.js"></script>
</head>
<body>

	
	<div id="listAllrequest">

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



		<a href="bloodBankHome.jsp">Home</a>

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
							<td><input type="submit" name="process" value="Acknowledge"></td>
							<td><input type="submit" name="process" value="Deny"></td>

							

							<%
								
										} else {
							%>


							<td><input type="submit" name="process" value="Acknowledge"
								disabled="disabled"></td>
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
</body>
</html>

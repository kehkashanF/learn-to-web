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

<%-- <% --%>
<!-- // // Page will be auto refresh after 1 seconds -->
<!-- // response.setIntHeader("Refresh",5); -->



<%-- %>    --%>
<!-- <div id="getBank"> -->


<!-- // if(session!=null){ -->
<%-- <%-- } %> --%> 
<!-- </form> -->
<!-- </div> -->
<div id="listAllrequest">
                   
					<h2>My Requests</h2>
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
									<th>Acknowledge</th>
									<th>Deny</th>
								</tr>
							</thead>
							<tbody>
								<tr class="info">
									<th scope="row">1</th>

									<%
										BloodBankDAOImpl bbd=new BloodBankDAOImpl();
									   
										List<Request> bbs=bbd.seeAllRequests((BloodBank)session.getAttribute("bloodBank"));
										if(bbs != null){
											for (Request r:bbs) {
										
									%>
									<tr>
									<td><%="REQ"+r.getRequestId()%></td>
									<td><%=r.getBloodgroup()%></td>
									<td><%=r.getBloodType()%></td>
									<td><%=r.getQuantity_required()%></td>
									<td><%=r.getDelivery_date_time()%></td>
								<form action="BloodBankServlet">
									<td><input type="hidden" value="<%=r.getRequestId()%>" name="rId"></td>
                                    <td><input type="submit" name="process" value="Acknowledge" ></td>
                                    <td><input type="submit" name="process" value="Deny"  ></td>
                                 </form>  
                                    </tr>
									<%
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


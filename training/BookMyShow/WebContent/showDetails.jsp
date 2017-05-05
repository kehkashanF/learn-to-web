<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.StringReader"%>

<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import=" org.codehaus.jettison.json.JSONException"%>
<%@page import=" org.codehaus.jettison.json.JSONObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showDetails</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<%
		String movie=(String)session.getAttribute("movie");
	JSONArray array;
	try {
		JSONObject j = new JSONObject(movie);
	%>
		<%= j.get("Movie") %> <br>
	<% 	array =j.getJSONArray("Shows");
		    
		for(int i=0;i<array.length();i++){
			JSONObject obj = array.getJSONObject(i);
		%>
		<%= obj.get("day") %> 
		<a href="tickets.jsp?movieId=<%=j.get("@movieId")%>&showId=<%=obj.get("@showId")%>">
				<%=obj.get("time") %>
				 </a><br>
				
		
		<% 	
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    
   	 %>
</body>
</html>
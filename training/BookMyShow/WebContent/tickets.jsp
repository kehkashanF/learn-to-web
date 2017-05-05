<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import=" org.codehaus.jettison.json.JSONException"%>
<%@page import=" org.codehaus.jettison.json.JSONObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<%
	
	String movie=(String)session.getAttribute("movie");
	String m_id=request.getParameter("movieId");
	String s_id=request.getParameter("showId");
	JSONArray array;
	try {
		JSONObject j = new JSONObject(movie);
	%>
		<%= j.get("Movie") %> <br>
	<% 	array =j.getJSONArray("Shows");
		    
		for(int i=0;i<array.length();i++){
			JSONObject obj = array.getJSONObject(i);
			String show=(String)obj.get("@showId");
			if(show.equals(s_id)){
		%>
		
		<%= obj.get("day") %> <br>
		<%=obj.get("time") %><br>
		Available Tickets: <%=obj.get("seats")%><br>
		<form action="bookShow" method="post">
			<input type="hidden" value="<%=j.get("@movieId")%>" name="m_id">
			<input type="hidden" value="<%=obj.get("@showId")%>" name="s_id">
			Enter Tickets: <input type="text" name="tickets"><br>
			<input type="submit" value="Submit">
		</form>
			<br>
				
		
		<% 	
		
			}
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    
   	 %>
</body>
</html>
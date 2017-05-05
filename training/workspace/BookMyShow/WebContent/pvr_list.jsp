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
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<%
		String movies_list=(String)session.getAttribute("movies_list");
		
		JSONArray array;
		try {
			JSONObject j = new JSONObject(movies_list);
			Object check=j.get("movie");
			if(check instanceof JSONArray){
				array =j.getJSONArray("movie");
				    
				for(int i=0;i<array.length();i++){
					JSONObject obj = array.getJSONObject(i);
	%>
						<a href="showTiming?movieId=<%=obj.get("@movieId")%>"> <%= obj.get("Movie") %> <br></a>
	<% 	
				}
			}
			else{
				JSONObject obj1 = (JSONObject)j.get("movie");
	%>
				<a href="showTiming?movieId=<%=obj1.get("@movieId")%>"> <%= obj1.get("Movie") %> <br></a>
	<% 	
		}
			} catch (JSONException e) {
				e.printStackTrace();
		}
	
    
   	 %>
</body>
</html>
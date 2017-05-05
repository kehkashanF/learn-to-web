package com.psl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class showTiming extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s_id=request.getParameter("movieId");
		Client client=Client.create();
		
		WebResource resource = client.resource("http://localhost:8181/04-PVR/fetch/"+s_id);
		
		ClientResponse c_response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class); 
		
		String movie=c_response.getEntity(String.class);
		
		HttpSession session=request.getSession();
		session.setAttribute("movie", movie);
		
		request.getRequestDispatcher("showDetails.jsp").forward(request, response);
	}

}

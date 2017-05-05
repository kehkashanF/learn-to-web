package com.psl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class bookShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id=request.getParameter("m_id");
		String s_id=request.getParameter("s_id");
		String tickets=request.getParameter("tickets");
		Client client=Client.create();
		
		WebResource resource=client.resource("http://localhost:8181/04-PVR/book?movieId="+m_id+"&showId="+s_id+"&tickets="+tickets);
		
		ClientResponse c_response=resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String msg=c_response.getEntity(String.class);
		
		PrintWriter out=response.getWriter();

		out.println("<h1>"+msg+"</h1>");
	}

}

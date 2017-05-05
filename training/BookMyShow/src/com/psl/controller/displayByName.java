package com.psl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class displayByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String match=request.getParameter("mname");
		Client client=Client.create();
		WebResource resource= client.resource("http://localhost:8181/04-PVR/movLike/"+match);
		ClientResponse c_response=resource.accept("application/json").get(ClientResponse.class);
		
		String movies_list = c_response.getEntity(String.class);
		HttpSession session=request.getSession();
		session.setAttribute("movies_list", movies_list);
		
		RequestDispatcher rd=request.getRequestDispatcher("pvr_list.jsp");
		rd.forward(request, response);
	}

}

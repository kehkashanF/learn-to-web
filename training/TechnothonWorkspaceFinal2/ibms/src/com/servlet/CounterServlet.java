package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BloodBankDAOImpl;

/**
 * Servlet implementation class CounterServlet
 */
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int requestId = Integer.parseInt(request.getParameter("rId"));
		int bloodBankId = Integer.parseInt(request.getParameter("bId"));
		int donorId = Integer.parseInt(request.getParameter("dId"));
		String value = request.getParameter("na");
		System.out.println(value + "\n\n\\n\n");
		System.out.println(requestId);
		if(value.equalsIgnoreCase("Available")){
			new BloodBankDAOImpl().addDonatingDonors(requestId);
			System.out.println(value);
		}	
		else
		{
			System.out.println("\n\n\n\n navai");
		}
	}
	
}

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAOImpl;

/**
 * Servlet implementation class CancelRequestServlet
 */
public class CancelRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.parseInt(request.getParameter("rId"));
		String flag = new HospitalDAOImpl().cancelRequest(requestId);
		response.sendRedirect("HospitalHome.jsp");
	}

}

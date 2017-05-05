package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Hospital;
import com.dao.HospitalDAOImpl;

/**
 * Servlet implementation class EditDetailsHospitalServlet
 */
public class EditDetailsHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		hospital.setOfficer_name(request.getParameter("newOfficer"));
		hospital.setHospital_contactNo(request.getParameter("newNumber"));
		new HospitalDAOImpl().editDetails(hospital);
		response.sendRedirect("HospitalHome.jsp");
	}

}

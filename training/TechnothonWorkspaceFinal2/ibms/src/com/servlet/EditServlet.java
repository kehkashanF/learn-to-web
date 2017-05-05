package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodBank;
import com.dao.BloodBankDAOImpl;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BloodBank bloodbank = (BloodBank)session.getAttribute("bloodBank");
		bloodbank.setBTO_name(request.getParameter("newBTO"));
		bloodbank.setBloodBank_mobileNo(request.getParameter("newContact"));
		new BloodBankDAOImpl().editDetails(bloodbank);
	
		response.sendRedirect("bloodBankHome.jsp");
	}

}

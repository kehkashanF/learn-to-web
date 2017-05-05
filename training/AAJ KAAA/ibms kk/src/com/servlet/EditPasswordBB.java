package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.User;
import com.dao.HospitalDAOImpl;
import com.dao.UserDAOImpl;
import com.util.SHA;


public class EditPasswordBB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		BloodBank bloodBank = (BloodBank)session.getAttribute("bloodBank");
		PrintWriter out=response.getWriter();
		out.println(bloodBank.getBloodBank_emailId());
		out.println(request.getParameter("oldPassword"));
		out.println(request.getParameter("newPassword"));
		User user=new UserDAOImpl().getUser(bloodBank.getBloodBank_emailId());
		if(user.getPassword().equals(new SHA().getSHA1SecurePassword(request.getParameter("oldPassword"))))
		{	
			user.setPassword(new SHA().getSHA1SecurePassword(request.getParameter("newPassword")));
			new UserDAOImpl().editDetails(user);
			response.sendRedirect("PasswordResetSuccess.jsp");
		}
		else{
//			response.sendRedirect("editPassword.jsp/status=no");
		}
	}

}

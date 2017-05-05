package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Hospital;
import com.bean.User;
import com.dao.HospitalDAOImpl;
import com.dao.UserDAOImpl;
import com.util.SHA;


public class EditPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Hospital hospital = (Hospital)session.getAttribute("hospital");
		User user=new UserDAOImpl().getUser(hospital.getHospital_email());
		if(user.getPassword().equals(new SHA().getSHA1SecurePassword(request.getParameter("oldPassword"))))
		{	
			user.setPassword(new SHA().getSHA1SecurePassword(request.getParameter("newPassword")));
			new UserDAOImpl().editDetails(user);
			response.sendRedirect("PasswordResetSuccess.jsp");
		}
		else{
			response.sendRedirect("editPassword.jsp/status=no");
		}
	}

}

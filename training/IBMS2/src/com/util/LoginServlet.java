package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Hospital;
import com.dao.IbmsDAO;
import com.dao.IbmsDAOImpl_template;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("email1");
		String password = request.getParameter("password1");
		Hospital hospital = new Hospital();
		hospital.setHospital_email(username);
		hospital.setHospital_password(new SHA().getSHA1SecurePassword(password));
		PrintWriter out = response.getWriter();
		out.print(new IbmsDAOImpl_template().loginHospital(hospital));
		
	}

}

package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Hospital;
import com.bean.User;
import com.dao.IbmsDAOImpl;
import com.util.SHA;
import com.validators.HospitalRegisterValidator;

/**
 * Servlet implementation class RegisterValidationController
 */
public class HospitalRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HospitalRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hName = request.getParameter("hName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String oName = request.getParameter("oName");
		String contact = request.getParameter("contact");
		String lNum = request.getParameter("lNum");
		String cert = request.getParameter("cert");
		String address = request.getParameter("address");
		String pincode = request.getParameter("pincode");
		HospitalRegisterValidator validator = new HospitalRegisterValidator();
		HttpSession session = request.getSession();
		List<String> errorMessages = validator.validate(hName, email, password,
				password1, oName, contact, lNum, cert, address, pincode);
		if (errorMessages.size() == 0) {
			Hospital hospital = new Hospital();
			User user = new User();
			hospital.setHospital_name(hName);
			hospital.setHospital_email(email);
			user.setEmail(email);
			user.setPassword(new SHA().getSHA1SecurePassword(password));
			user.setRole(0);
			hospital.setOfficer_name(oName);
			hospital.setHospital_contactNo(contact);
			hospital.setHospital_lisenceNo(lNum);
			hospital.setHospital_certification(cert);
			hospital.setHospital_address(address);
			hospital.setHospital_pin(Integer.parseInt(pincode));
			IbmsDAOImpl ibms = new IbmsDAOImpl();
			// ibms.addhospital(hospital);
			String flag = ibms.addhospital(hospital, user);
			if (flag.equalsIgnoreCase("true")) {
				response.sendRedirect("RegistrationSuccess.jsp");
			} else {
				errorMessages.add("Already Registered user!!");
				session.setAttribute("errorMessages", errorMessages);
				response.sendRedirect("HospitalRegistration.jsp");
			}
		} else {
			session.setAttribute("errorMessages", errorMessages);
			response.sendRedirect("HospitalRegistration.jsp");
		}

	}

}

package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodGroup;
import com.bean.BloodType;
import com.bean.Hospital;
import com.bean.Request;
import com.dao.HospitalDAOImpl;
import com.dao.IbmsDAOImpl;
import com.validators.RequestValidator;

/**
 * Servlet implementation class FrontController
 */
// @WebServlet("/FrontController")
public class RequestSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// System.out.println("hi from front controller");
		String patientname = request.getParameter("patientname");
		String doctorname = request.getParameter("doctorname");
		String rbg = request.getParameter("rbg");
		String requiredtime = request.getParameter("requiredtime");
		Integer units = Integer.parseInt(request.getParameter("units"));
		String bloodtype = request.getParameter("bloodtype");
		RequestValidator validator = new RequestValidator();
		List<String> errorMessages = validator.validate(patientname,
				doctorname, rbg, requiredtime, units, bloodtype);
		if (errorMessages.size() == 0) {
			Request request2 = new Request();
			// set hospital
			HttpSession httpSession  = request.getSession();
			Hospital hospital = null;
			if(httpSession!= null)
				hospital = (Hospital) httpSession.getAttribute("hospital");
			
			
			 
			request2.setHospital(hospital);
			request2.setPatient_name(patientname);
			request2.setDoctor_name(doctorname);
			request2.setBloodgroup(BloodGroup.valueOf(rbg));
			request2.setDelivery_date_time(requiredtime);
			request2.setQuantity_required(units);
			request2.setBloodType(BloodType.valueOf(bloodtype));
			request2.setStatus(1);
			HospitalDAOImpl hospitaldao = new HospitalDAOImpl();
			hospitaldao.addRequest(request2);
			response.sendRedirect("HospitalHome.jsp?submit=true");
			
			
			IbmsDAOImpl ibmsDAOImpl = new IbmsDAOImpl();
			ibmsDAOImpl.processRequest(request2);
			
			
			

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errorMessages", errorMessages);
			System.out.println("Errors: "+errorMessages);
			response.sendRedirect("HospitalHome.jsp");
		}

	}

}

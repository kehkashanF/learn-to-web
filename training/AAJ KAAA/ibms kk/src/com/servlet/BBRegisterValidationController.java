package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodBank;
import com.bean.User;
import com.dao.IbmsDAOImpl;
import com.util.SHA;
import com.validators.BloodBankRegisterValidator;

/**
 * Servlet implementation class BBRegisterValidationController
 */
public class BBRegisterValidationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bName=request.getParameter("bName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String btoName=request.getParameter("btoName");
		String contact=request.getParameter("contact");
		String lNum=request.getParameter("lNum");
		String circle=request.getParameter("circle");
		String address=request.getParameter("address");
		String pincode=request.getParameter("pincode");
		String func=request.getParameter("func");
		HttpSession session = request.getSession();
		BloodBankRegisterValidator bbvalid=new BloodBankRegisterValidator();
		List<String> errorMessages=bbvalid.validate(bName, email, password, password1, btoName, contact, lNum, circle, address, pincode, func);
		if(errorMessages.size()==0)
		{
			BloodBank bb=new BloodBank();
			User user=new User();
		    bb.setBloodBank_name(bName);
		    bb.setBloodBank_emailId(email);
		    user.setEmail(email);
		    user.setPassword(new SHA().getSHA1SecurePassword(password));
		    user.setRole(1);
		    bb.setBTO_name(btoName);
		    bb.setBloodBank_mobileNo(contact);
		    bb.setFDA_lisenceNo(lNum);
		    bb.setBloodBank_circle(circle);
		    bb.setBloodBank_address(address);
		    bb.setBloodBank_pin(Integer.parseInt(pincode));
		    if(func.equalsIgnoreCase("yes")){bb.setFunctional(true);}else{bb.setFunctional(false);}
		    
			IbmsDAOImpl ibms=new IbmsDAOImpl();
			String flag = ibms.addBloodBank(bb, user);
			if(flag.equalsIgnoreCase("true")){
				response.sendRedirect("RegistrationSuccess.jsp");
			}
			else
			{
				errorMessages.add("Already Registered user!!");
				session.setAttribute("errorMessages",errorMessages);
				response.sendRedirect("BloodBankRegistration.jsp");
			}
		}
		else
		{
			
			session.setAttribute("errorMessages",errorMessages);
			response.sendRedirect("BloodBankRegistration.jsp");
		}	
		
		
	}

}

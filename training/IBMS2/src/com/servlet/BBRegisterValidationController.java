package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodBank;
import com.bean.BloodGroup;
import com.bean.BloodType;
import com.bean.Hospital;
import com.bean.Request;
import com.dao.HospitalDAOImpl_template;
import com.dao.IbmsDAOImpl_template;
import com.validators.BloodBankRegisterValidator;
import com.validators.HospitalRegisterValidator;
import com.validators.RequestValidator;

/**
 * Servlet implementation class BBRegisterValidationController
 */
public class BBRegisterValidationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBRegisterValidationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		BloodBankRegisterValidator bbvalid=new BloodBankRegisterValidator();
		List<String> errorMessages=bbvalid.validate(bName, email, password, password1, btoName, contact, lNum, circle, address, pincode, func);
		if(errorMessages.size()==0)
		{
			BloodBank bb=new BloodBank();
		    bb.setBloodBank_name(bName);
		    bb.setBloodBank_emailId(email);
		    bb.setBloodBank_password(password);
		    bb.setBTO_name(btoName);
		    bb.setBloodBank_mobileNo(contact);
		    bb.setFDA_lisenceNo(lNum);
		    bb.setBloodBank_circle(circle);
		    bb.setBloodBank_address(address);
		    bb.setBloodBank_pin(Integer.parseInt(pincode));
		    if(func.equalsIgnoreCase("yes")){bb.setFunctional(true);}else{bb.setFunctional(false);}
		    
			IbmsDAOImpl_template ibms=new IbmsDAOImpl_template();
			ibms.addBloodBank(bb);
			
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessages",errorMessages);
			response.sendRedirect("BloodBankRegistration.jsp");
		}	
		
		
	}

}

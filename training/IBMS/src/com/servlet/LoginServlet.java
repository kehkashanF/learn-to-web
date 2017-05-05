package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.User;
import com.dao.IbmsDAO;
import com.dao.IbmsDAOImpl;
import com.util.SHA;

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
		User user = new User();
		user.setEmail(username);
		user.setPassword(new SHA().getSHA1SecurePassword(password));
		PrintWriter out = response.getWriter();
		response.setContentType("javascript/json");
		
		IbmsDAO ido=new IbmsDAOImpl();
		int check=ido.loginUser(user);
		 
		
			if(check==0){//HOSPITAL
				Hospital hospital=ido.loginHospital(username);
				request.getSession().setAttribute("hospital", hospital);
//				request.getRequestDispatcher("HospitalHome.jsp").forward(request, response);
				out.print("{\"response\":\"true\", \"next\":\"hospital\"}");
			}
			else if(check==1){
				BloodBank bloodBank=ido.loginBloodBank(username);
				request.getSession().setAttribute("bloodBank", bloodBank);
//				request.getRequestDispatcher("bloodBankHome.jsp").forward(request, response);
				out.print("{\"response\":\"true\", \"next\":\"bloodBank\"}");
				
				System.out.println("\n\n\n\\n\n\n\\n\nbb id:"+bloodBank.getBloodBank_id()+"\n\n\n\n\n\n\n\n");
				
				
			}
			else
				out.print("{\"response\": \"false\"}");
			
		}
		
}

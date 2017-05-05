package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BloodBank;
import com.bean.Request;
import com.dao.BloodBankDAOImpl;
import com.dao.IbmsDAOImpl;

/**
 * Servlet implementation class BloodBankServlet
 */
public class BloodBankServlet extends HttpServlet {
	static int count = 1;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n\n\n\n\n\n\\n\ndone\n\n\n\n\n");
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (request.getParameter("process").equals("Acknowledge")) {
				BloodBankDAOImpl bbd = new BloodBankDAOImpl();

				// Request r=(Request)session.getAttribute("processrequest");
				Request r = (new IbmsDAOImpl()).getRequest(Integer
						.parseInt(request.getParameter("rId")));
				// PrintWriter out=response.getWriter();
				// out.println(r.getRequestId());
				// out.println(r.getDoctor_name());
				bbd.acknowledge(r);
				// response.sendRedirect("TEST.jsp?rId="+r.getRequestId());
				// PrintWriter out=response.getWriter();
				// out.println("Request Acknowledged");
				// response.sendRedirect("MyRequests.jsp");
				response.sendRedirect("MyRequests.jsp");

			} else if(request.getParameter("process").equals("Deny")) {
				BloodBankDAOImpl bbd = new BloodBankDAOImpl();
				// Request r=(Request)session.getAttribute("processrequest");
				Request r = new IbmsDAOImpl().getRequest(Integer
						.parseInt(request.getParameter("rId")));

				bbd.deny(r);
				// PrintWriter out=response.getWriter();
				// out.println(r.getRequestId());
				response.sendRedirect("MyRequests.jsp");

			}
//			else if(request.getParameter("process").equals("Dispatch")) {
//				BloodBankDAOImpl bbd = new BloodBankDAOImpl();
//				// Request r=(Request)session.getAttribute("processrequest");
//				Request r = new IbmsDAOImpl().getRequest(Integer
//						.parseInt(request.getParameter("rId")));
//
//				bbd.dispatch(r);
//				// PrintWriter out=response.getWriter();
//				// out.println(r.getRequestId());
//				response.sendRedirect("MyRequests.jsp");
//
//			}

		}

	}

}

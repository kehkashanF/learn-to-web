package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name=request.getParameter("uname");
				String pwd=request.getParameter("pwd");
				 
				if(name.equals("Kehkashan") && pwd.equals("abc123")){
					RequestDispatcher rd =request.getRequestDispatcher("ValidUser");
					rd.forward(request, response);
				}		
				else		
					response.sendRedirect("InvalidUser");
			
					
	}

}

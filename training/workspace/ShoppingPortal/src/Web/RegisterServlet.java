package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Users;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		
		Users u=new Users(name, email,phone, pwd);
		if(u.storeUser())
			response.sendRedirect("RegSucServlet");
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Could not register...");
			response.sendRedirect("HomeServlet");
		}
		
		
	}

}

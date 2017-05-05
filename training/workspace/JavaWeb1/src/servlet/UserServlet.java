package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class UserServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private int count;

	public void init() throws ServletException {
		System.out.println("Init");
		count=0;
	}

	public void destroy() {
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				count++;
				PrintWriter out=response.getWriter();
				out.println("You are user no.: "+count);
				
	}


}

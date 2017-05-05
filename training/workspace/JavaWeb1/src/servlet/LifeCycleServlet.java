package servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init");
	}

	
	public void destroy() {
		System.out.println("inside destroy");
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Inside service method");
	}

}

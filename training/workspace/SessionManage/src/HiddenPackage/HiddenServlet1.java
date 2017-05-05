package HiddenPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<form action=HiddenServlet2>");
		out.println("<input type=hidden name=uname value="+name+" />");
		out.println("<input type=submit value=Click />");
		out.println("</form></body></html>");
	}

}

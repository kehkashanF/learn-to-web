/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2015-12-19 10:24:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.css;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--Author: W3layouts\r\n");
      out.write("Author URL: http://w3layouts.com\r\n");
      out.write("License: Creative Commons Attribution 3.0 Unported\r\n");
      out.write("License URL: http://creativecommons.org/licenses/by/3.0/\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("<script src=\"js/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("<!-- Custom Theme files -->\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<!-- Custom Theme files -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<script type=\"application/x-javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!--Google Fonts-->\r\n");
      out.write("<link href='//fonts.googleapis.com/css?family=Squada+One'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("<link\r\n");
      out.write("\thref='//fonts.googleapis.com/css?family=Source+Sans+Pro:400,200,300,600,700,900'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("<!-- start-smoth-scrolling -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/move-top.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tjQuery(document).ready(function($) {\r\n");
      out.write("\t\t$(\".scroll\").click(function(event) {\r\n");
      out.write("\t\t\tevent.preventDefault();\r\n");
      out.write("\t\t\t$('html,body').animate({\r\n");
      out.write("\t\t\t\tscrollTop : $(this.hash).offset().top\r\n");
      out.write("\t\t\t}, 1000);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<!-- //end-smoth-scrolling -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".error-password {\r\n");
      out.write("\tcolor: #FF0000;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--banner start here-->\r\n");
      out.write("\t<div class=\"banner-two\">\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"header-main\">\r\n");
      out.write("\t\t\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"\"> IBMS Connect</a>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"top-nav\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"menu\"> <img src=\"images/icon.png\" alt=\"\" /></span>\r\n");
      out.write("\t\t\t\t\t\t<nav class=\"cl-effect-1\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"res\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"index.html\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"active\" href=\"about.html\">About</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"services.html\">Services</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"gallery.html\">Gallery</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"shortcords.html\">Short Codes</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact.html\">Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t\t<!-- script-for-menu -->\r\n");
      out.write("\t\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\t\t$(\"span.menu\").click(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"ul.res\").slideToggle(300, function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t// Animation complete.\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t<!-- /script-for-menu -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--banner end here-->\r\n");
      out.write("\t<!--about start here-->\r\n");
      out.write("\t<div class=\"about\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"about-main\">\r\n");
      out.write("\t\t\t\t<div class=\"about-top\">\r\n");
      out.write("\t\t\t\t\t<h2>Password Reset Success!!</h2>\r\n");
      out.write("\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\tYou password has been reset successfully. <a href=\"login.jsp\">Click\r\n");
      out.write("\t\t\t\t\t\t\there</a> to Login.\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						if (request.getParameter("type").equals("bb")) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t<form action=\"EditPasswordBB\" method=\"post\"> -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\tEnter old password: <input type=\"password\" name=\"oldPassword\"> -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\tEnter new password: <input type=\"password\" name=\"newPassword\" -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\t\tid=\"np1\"> Re-enter new password: <input type=\"password\" -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\t\tname=\"tpPassword\" id=\"np2\" onblur=\"checkEqual()\"> <label -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\t\tid=\"l1\" class=\"error-password\">Passwords do not match!</label> <input -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t\t\ttype=\"submit\" name=\"Submit\"> -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t</form> -->\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<form action=\"EditPasswordBB\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<table align=center>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><label class=\"sr-only\" for=\"exampleInputEmail3\">Enter\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tcurrent password:</label> Enter current password:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"password\" name=\"oldPassword\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Current Password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"width: 300px;\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><label class=\"sr-only\" for=\"exampleInputEmail3\">Enter\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tnew password:</label> Enter new password:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"password\" name=\"newPassword\" id=\"np1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" placeholder=\"New Password\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><label class=\"sr-only\" for=\"exampleInputEmail3\">Re-enter\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tnew password:</label> Re-enter new password:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><input type=\"password\" name=\"tpPassword\" id=\"np2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonblur=\"checkEqual()\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Re-enter password\"> <label id=\"l1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"error-password\">Passwords do not match!</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<form action=\"EditPasswordServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\tEnter old password: <input type=\"password\" name=\"oldPassword\">\r\n");
      out.write("\t\t\t\t\t\tEnter new password: <input type=\"password\" name=\"newPassword\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"np1\"> Re-enter new password: <input type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"tpPassword\" id=\"np2\" onmouseout=\"checkEqual()\"> <label\r\n");
      out.write("\t\t\t\t\t\t\tid=\"l1\" class=\"error-password\">Passwords do not match!</label> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"submit\" name=\"Submit\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\tfunction confirmPassword() {\r\n");
      out.write("\t\t\t\t\t\t\tvar pwd1 = document.getElementById(\"pwd1\").value;\r\n");
      out.write("\t\t\t\t\t\t\tvar pwd2 = document.getElementById(\"pwd2\").value;\r\n");
      out.write("\t\t\t\t\t\t\tif (pwd1 === pwd2) {\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"l1\").style.display = \"none\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"l1\").style.display = \"inline\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

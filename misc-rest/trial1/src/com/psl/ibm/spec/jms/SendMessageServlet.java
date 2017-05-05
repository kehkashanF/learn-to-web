package com.psl.ibm.spec.jms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.psl.ibm.spec.dao.Constant;

import javax.jms.*;
import javax.naming.InitialContext;

import java.util.Date;

@WebServlet(name = "SendMessageServlet", urlPatterns = "/employeesQ")
public class SendMessageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(SendMessageServlet.class);
	private static int i = 0;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		logger.info("doGet() called");

		String parameter = getTextParameter(httpServletRequest);
		sendMessage(parameter);
		writeResponse(httpServletResponse, parameter);
	}

	private void writeResponse(HttpServletResponse httpServletResponse,
			String parameter) throws IOException {
		httpServletResponse.setContentType(MediaType.APPLICATION_XML);
		httpServletResponse.getWriter().write(
				String.format("Sent message with content '%s'.", parameter));
	}

	private String getTextParameter(HttpServletRequest httpServletRequest) {
		String orderByAsc = httpServletRequest
				.getParameter(Constant.QUERY_PARAM_ORDERBYASC);
		String orderByDesc = httpServletRequest
				.getParameter(Constant.QUERY_PARAM_ORDERBYDESC);
		String designation = httpServletRequest
				.getParameter(Constant.QUERY_PARAM_DESIGNATION);
		String name = httpServletRequest
				.getParameter(Constant.QUERY_PARAM_NAME);
		String id = httpServletRequest.getParameter(Constant.QUERY_PARAM_ID);
		String age = httpServletRequest.getParameter(Constant.QUERY_PARAM_AGE);
		Client client = ClientBuilder.newClient(new ClientConfig()
		.register(LoggingFilter.class));
		WebTarget target = client.target("http://localhost:8080/trial").path(
				Constant.EMPLOYEE_PATH);
		// JSON
		Response response = target
				.queryParam(Constant.QUERY_PARAM_ORDERBYASC, orderByAsc)
				.request(MediaType.APPLICATION_JSON_TYPE).get();
			
		return response.toString();
	}

	/*private String getTextParameter(HttpServletRequest httpServletRequest) {
		String parameter = httpServletRequest.getParameter("text");
    	if(Strings.isNullOrEmpty(parameter)) {
    		parameter = (new Date()).toString()+(new Integer(i)).toString();
    		i++;
    	}
		return parameter;
	}
	 * */
	private void sendMessage(String text) {
		try {
			InitialContext initCtx = new InitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory) initCtx
					.lookup("java:comp/env/jms/ConnectionFactory");
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session
					.createProducer((Destination) initCtx
							.lookup("java:comp/env/jms/queue/MyQueue"));

			TextMessage testMessage = session.createTextMessage();
			testMessage.setText(text);
			testMessage.setStringProperty("aKey", "someRandomTestValue");
			producer.send(testMessage);
			logger.debug("Successfully sent request");
		} catch (Exception e) {
			logger.error("Sending JMS message failed: " + e.getMessage(), e);
		}
	}
}

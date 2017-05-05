package com.psl.ibm.spec.exceptions;

import javax.ws.rs.core.Response;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmployeeExceptionMapper implements
		ExceptionMapper<EmployeeException> {

	@Override
	public Response toResponse(EmployeeException exception) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;

		if (exception instanceof EmployeeException)
			httpStatus = Response.Status.BAD_REQUEST;

		return Response.status(httpStatus)
				.entity(exception.getMessages().toString()).build();

	}

}

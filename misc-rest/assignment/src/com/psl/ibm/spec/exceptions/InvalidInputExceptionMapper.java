package com.psl.ibm.spec.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.xml.bind.ValidationException;

public class InvalidInputExceptionMapper implements ExceptionMapper<Throwable> {

	/**
	 * Checks validity of bean class input, if illegal argument exception is
	 * thrown, 400 Error is sent in response status
	 */
	@Override
	  public Response toResponse(Throwable exception) {
	    Throwable badRequestException 
	        = getBadRequestException(exception);
	    if (badRequestException != null) {
	      return Response.status(Status.BAD_REQUEST)
	          .entity(badRequestException.getMessage())
	          .build();
	    }
	    if (exception instanceof WebApplicationException) {
	        return ((WebApplicationException)exception)
	            .getResponse();
	      }
	    
	    return Response.serverError()
	        .entity(exception.getMessage())
	        .build();
	  }
	 
	  private Throwable getBadRequestException(
	      Throwable exception) {
	    if (exception instanceof ValidationException) {
	      return exception;
	    }
	    Throwable cause = exception.getCause();
	    if (cause != null && cause != exception) {
	      Throwable result = getBadRequestException(cause);
	      if (result != null) {
	        return result;
	      }
	    }
	    if (exception instanceof IllegalArgumentException) {
	      return exception;
	    }
	    if (exception instanceof BadRequestException) {
	      return exception;
	    }
	    return null;
	  }

}

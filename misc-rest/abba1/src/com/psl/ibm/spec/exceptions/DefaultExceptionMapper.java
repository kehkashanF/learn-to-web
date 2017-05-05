package com.psl.ibm.spec.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.ValidationException;

@Provider
public class DefaultExceptionMapper 
    implements ExceptionMapper<Throwable> {
 
  @Override
  public Response toResponse(Throwable exception) {
    Throwable badRequestException 
        = getBadRequestException(exception);
    if (badRequestException != null) {
      return Response.status(Status.BAD_REQUEST)
          .entity("This message")
          .build();
    }
    if (exception instanceof WebApplicationException) {
      return ((WebApplicationException)exception)
          .getResponse();
    }
    return Response.serverError()
        .entity("kachu nai")
        .build();
  }
 
  private Throwable getBadRequestException(
      Throwable exception) {
    if (exception instanceof ValidationException) {
    	System.out.println("ve");
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
    	System.out.println("ie");
      return exception;
    }
    if (exception instanceof BadRequestException) {
    	System.out.println("be");
      return exception;
    }
    return null;
  }
 
}

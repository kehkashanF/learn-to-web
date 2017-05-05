package com.psl.services;

import java.sql.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("/")
public class HeloWorldServices { //resource class --> resource methods
	static int i;
	
	public HeloWorldServices() {
		i++;
	}
	
	@Path("/greet")
	@GET
	//@Produces(value=MediaType.TEXT_PLAIN)
	public Date sayHello(){ //resource method
		
		return Date.valueOf("2011-11-11");
		
	
	}
	
	@Path("/insult")
	@GET
	@Produces(value=MediaType.TEXT_HTML)
	public String insultIt(){
		return "You are an idiot!";
	}
	
}

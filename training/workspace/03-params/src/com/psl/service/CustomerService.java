package com.psl.service;


import java.util.List;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Variant;

import com.psl.bean.AtomLink;
import com.psl.bean.Customer;
import com.psl.bean.Customers;
import com.psl.dao.CustomerDAO;
import com.psl.dao.CustomerNotFoundException;


@Path("/")
public class CustomerService {
	
			@Context
			private UriInfo uriInfo;
			
			@Context
			private HttpHeaders headers;
			
			@GET
			@Path("/fetch")
			@Produces(value=MediaType.TEXT_PLAIN)
			
			public String getCustomerByIdQueryParams(@QueryParam("id") int customerId, @Context UriInfo uriinfo) {
				
				Customer customer=new CustomerDAO().getCustomerById(customerId);
				return customer.toString();
				
			}
			
		
			
			@GET
			@Path("/fetch3/{id}") //{id} <-- template parameter
			@Produces(value=MediaType.TEXT_PLAIN )
			public String getCustomerByIdPathParams(@PathParam("id") int customerId) {
				
				Customer customer=new CustomerDAO().getCustomerById(customerId);
					return customer.toString();
			}
			
			
			@GET
			@Path("/fetch/{id}")
			@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
			public Response getCustomerById(@PathParam("id")int customerId) {
				Customer customer=new CustomerDAO().getCustomerById(customerId);
				return Response.ok(customer).build();
				
				
				
			}
			
			
			@POST
			@Path("/new")
			@Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
			public Response createCustomer(Customer customer){
				new CustomerDAO().save(customer);
				String result = "Customer saved: "+ customer;
				return Response.status(201).entity(result).build();
			}
			
			
			@POST
			@Path("/update/{id}")
			public Response updateCustomer(@PathParam("id") int customerId, 
									@DefaultValue("--no name--") @FormParam("fn") String firstName, 
									@DefaultValue("--no name--") @FormParam("ln") String lastName){
				Customer customer=new Customer(customerId, firstName, lastName);
				new CustomerDAO().update(customer);
				return Response.status(Status.OK).build();
				
			}
			
			
			
			
			@GET
			@Path("/delete/{id}")
			public Response deleteCustomer(@PathParam("id") int customerId){
				//Customer customer=new CustomerDAO().getCustomerById(customerId);
				new CustomerDAO().delete(customerId);
				return Response.status(Status.OK).build();
			}
			
			//MATRIX PARAMS
			//http://localhost:8181/03-params/fetch1/11;mark=true;show=false/12;mark=true;show=true/13;mark=false;show=true
//			@GET
//			@Path("/fetch1/{id:.+}")
//			public void markCustomers(@PathParam("id") List<PathSegment> segments)
//			{
//				for(PathSegment segment:segments){
//					System.out.println(segment.getPath());
//				 	System.out.println(segment.getMatrixParameters().get("mark"));
//					System.out.println(segment.getMatrixParameters().get("show"));
//				}
//			}
			
			
			
			///////////////////////////use of VARIANTS (Day3)///////////////////////////////////
			
			@GET
			@Path("/simple")
			public Response simpleService(@Context Request request){
				List<Variant> variants = Variant.languages(new Locale(Locale.ENGLISH.getLanguage(), 
																				Locale.US.getCountry()),
														new Locale(Locale.FRENCH.getLanguage(), 
																		Locale.FRANCE.getCountry()),
														new Locale(Locale.ENGLISH.getLanguage(), 
																			Locale.UK.getCountry())
														)	
									.mediaTypes(MediaType.APPLICATION_JSON_TYPE, 
														MediaType.APPLICATION_XML_TYPE)
									.add()
									.build();
				
				Variant selectedVariant = request.selectVariant(variants);
				
				System.out.println(selectedVariant.getLanguage());
				System.out.println(selectedVariant.getMediaType());
				
				return Response.noContent().build();
				
			}
			
			@GET
			@Path("/fetch-all")
			@Produces(value=MediaType.APPLICATION_XML)
			public Response getCustomers(@DefaultValue("0") @QueryParam("start") int start, 
										@DefaultValue("5") @QueryParam("size") int size){
				
				Customers customers=new CustomerDAO().getCustomers(start,size);
				
				for (Customer customer : customers.getCustomers()) {
					UriBuilder selfie=uriInfo.getBaseUriBuilder();
					selfie.path(CustomerService.class, "getCustomerById"); 
					
					//self
					customer.setSelf(new AtomLink(selfie.build(customer.getCustomerId()).toString(), MediaType.APPLICATION_XML, "self"));
					
				}
				UriBuilder parent=uriInfo.getBaseUriBuilder();
				parent.path(CustomerService.class, "getCustomers");
				
				parent.queryParam("start", start+size);
				parent.queryParam("Size", size);
				//next 
				customers.setNext(new AtomLink(parent.build().toString(), MediaType.APPLICATION_XML, "next"));
				
				if((start!=0)||((start-size)>=0)){
					UriBuilder prev=uriInfo.getBaseUriBuilder();
					prev.path(CustomerService.class, "getCustomers");
					prev.queryParam("start", start-size);
					prev.queryParam("size", size);
					//previous
					customers.setNext(new AtomLink(prev.build().toString(), MediaType.APPLICATION_XML, "previous"));
				}
				
				return Response.ok(customers).build();
			}
			
}

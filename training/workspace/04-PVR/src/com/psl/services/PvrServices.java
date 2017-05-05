package com.psl.services;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;




import com.psl.bean.Movie;
import com.psl.dao.PvrDAO;



@Path("/")
public class PvrServices {
	
			@Context
			private UriInfo uriInfo;
			
			@Context
			private HttpHeaders headers;

						
			@GET
			@Path("/fetch/{id}")
			@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
			public Response getMovieById(@PathParam("id")int movieId) {
				Movie movie=new PvrDAO().getMovieById(movieId);
				return Response.ok(movie).build();	
			}
			
			@GET
			@Path("/movLike/{name}")
			@Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
			public List<Movie> getMovieByName(@PathParam("name") String name){
				List<Movie> list=new ArrayList<Movie>();
				list=new PvrDAO().getMovieByName(name);
				return list;
			}

			@GET
			@Path("/book")
			public Response bookMovie(@QueryParam("movieId") int movieId, @QueryParam("showId") int showId, @QueryParam("tickets") int tickets){
				String msg=null;
				if(new PvrDAO().bookSeats(movieId, showId, tickets))
					msg="Movie has been booked!";
				else
					msg="Movie could not be booked. Try Again!";
				return Response.status(Status.OK).entity(msg).build();
			}
			
			@GET
			@Path("/display-all")
			@Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
			public List<Movie> getMovies(){
				
				List<Movie> movList=new ArrayList<Movie>();
				movList=new PvrDAO().getAllMovies();
				
				return movList;
			}

			
//			@GET
//			@Path("/fetch-all")
//			@Produces(value=MediaType.APPLICATION_XML)
//			public Response getCustomers(@DefaultValue("0") @QueryParam("start") int start, 
//										@DefaultValue("5") @QueryParam("size") int size){
//				
//				Customers customers=new CustomerDAO().getCustomers(start,size);
//				
//				for (Customer customer : customers.getCustomers()) {
//					UriBuilder selfie=uriInfo.getBaseUriBuilder();
//					selfie.path(CustomerService.class, "getCustomerById"); 
//					
//					//self
//					customer.setSelf(new AtomLink(selfie.build(customer.getCustomerId()).toString(), MediaType.APPLICATION_XML, "self"));
//					
//				}
//				UriBuilder parent=uriInfo.getBaseUriBuilder();
//				parent.path(CustomerService.class, "getCustomers");
//				
//				parent.queryParam("start", start+size);
//				parent.queryParam("Size", size);
//				//next 
//				customers.setNext(new AtomLink(parent.build().toString(), MediaType.APPLICATION_XML, "next"));
//				
//				if((start!=0)||((start-size)>=0)){
//					UriBuilder prev=uriInfo.getBaseUriBuilder();
//					prev.path(CustomerService.class, "getCustomers");
//					prev.queryParam("start", start-size);
//					prev.queryParam("size", size);
//					//previous
//					customers.setNext(new AtomLink(prev.build().toString(), MediaType.APPLICATION_XML, "previous"));
//				}
//				
//				return Response.ok(customers).build();
//			}
			
}


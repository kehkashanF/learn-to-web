package com.psl.main;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class Main {
	
		public void fetchClient(int id, Client client){
			
			
			WebResource resource=client.resource("http://localhost:8181/03-params/fetch/"+id);
			ClientResponse response=resource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			
			if(response.getStatus()!=200)
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			
			
			String output = response.getEntity(String.class);
		
			System.out.println(output);
			
			
		}
		
		public void createClient(int id, Client client)
		{
			
			Scanner s=new Scanner(System.in);
			
			System.out.println("Enter first name: ");
			String first_name = s.nextLine();
			System.out.println("Enter last name: ");
			String last_name=s.nextLine();
			
			WebResource create_resource=client.resource("http://localhost:8181/03-params/new");
			//String input = "{\"@id\":\""+id+"\",\"first-name\":\""+first_name+"\",\"last-name\":\""+last_name+"\"}";
			
			
			String input="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer id=\""+id+"\"><first-name>"+first_name+"</first-name><last-name>"+last_name+"</last-name></customer>";
			ClientResponse create_response=create_resource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, input);
			
			if(create_response.getStatus()!=201)
				throw new RuntimeException("Failed : HTTP error code : "
						+ create_response.getStatus());
			
			System.out.println("Output from server: ");
			String outty=create_response.getEntity(String.class);
			System.out.println(outty);
			
			//System.out.println(create_response);
			
		}
		
		public void updateClient(int id, Client client){
			
			Scanner s=new Scanner(System.in);
			WebResource resource=client.resource("http://localhost:8181/03-params/update/"+id);
			System.out.println("Enter first name: ");
			String fn = s.nextLine();
			System.out.println("Enter last name: ");
			String ln=s.nextLine();
			
			Form form=new Form();
			form.add("fn", fn);
			form.add("ln",ln);
			

			ClientResponse response1=resource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, form);
			if(response1.getStatus()!=200)
				throw new RuntimeException("Failed : HTTP error code : "
						+ response1.getStatus());
			else
				System.out.println("Customer Record Updated...");
		}
		
		
		public void deleteClient(int id, Client client){
			WebResource resource=client.resource("http://localhost:8181/03-params/delete/"+id);
			
			ClientResponse response_del=resource.get(ClientResponse.class);
			if(response_del.getStatus()!=200)
				throw new RuntimeException("Delete Failed : HTTP error code : "
						+ response_del.getStatus());
			else
				System.out.println("Customer record deleted...");
		}
		
		
		
		public static void main(String[] args) {
			
			Main m=new Main();
			
			Client client=Client.create();
			
			int ch;
			
			Scanner s=new Scanner(System.in);
			do{
			
				System.out.println("*********************MENU*********************");
				System.out.println("1. Fetch Customer");
				System.out.println("2. Create Customer");
				System.out.println("3. Update Customer");
				System.out.println("4. Delete Customer");
				System.out.println("Enter choice: ");
				int choice = Integer.parseInt(s.nextLine());
				
				
				switch(choice){
					case 1: 
						System.out.println("Enter the id of customer to fetch: ");
						int id;
						id=Integer.parseInt(s.nextLine());
						m.fetchClient(id, client);
						break;
//			WebResource resource=client.resource("http://localhost:8181/03-params/fetch3/"+id);
//			
//			String customer=resource.get(String.class);
//			System.out.println(customer);
			
			
			
	
			//create
					case 2:
							System.out.println("Creating customer: ");
							
							System.out.println("Enter the id of customer to create: ");
							id=Integer.parseInt(s.nextLine());
							
							m.createClient(id, client);
							m.fetchClient(id, client);
							break;
			
			
			//update
					case 3:
							System.out.println("Enter the id of customer to update: ");
							id=Integer.parseInt(s.nextLine());
							
							m.updateClient(id, client);
							m.fetchClient(id, client);
							break;
			
			//delete	
					case 4:
							System.out.println("Enter the id of customer to delete: ");
							 id=Integer.parseInt(s.nextLine());
							
							//m.fetchClient(id, client);
							break;
							
					default:
							System.out.println("Please enter valid choice...");
							break;
				}
				
				System.out.println("Do you wish to continue? (0/1)");
				ch=Integer.parseInt(s.nextLine());
			}while(ch==1);
			
			client.destroy();
		}
}

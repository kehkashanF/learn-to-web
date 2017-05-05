package com.psl.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.psl.bean.Customer;
import com.psl.bean.Customers;

public class CustomerDAO {
		
		private  static List<Customer> customers = new CopyOnWriteArrayList<Customer>();
		
		static{
			for(int index=1; index<=100; index++){
				Customer customer=new Customer(index, "firstName"+index, "lastName"+index);
				customers.add(customer);
			}
		}
		
		public Customer getCustomerById(int id) {
			Customer _customer = new Customer();
			_customer.setCustomerId(id);
			if(customers.indexOf(_customer)==-1)
				throw new CustomerNotFoundException();
			else
				return customers.get(customers.indexOf(_customer));
			//to use indexOf you must override hashCode and equals methods in bean class
			//WebApplicationException(Response.status(Status.BAD_REQUEST).build())
		}
	
		
		public void update(Customer customer) {
			Customer _customer=getCustomerById(customer.getCustomerId());
			
			_customer.setFirstName(customer.getFirstName());
			_customer.setLastName(customer.getLastName());
			
			
		}
		
		public void delete(int id) {
			Customer _customer=getCustomerById(id);
			
			customers.remove(customers.indexOf(_customer));
			
			
		}

		public void save(Customer customer) {
			customers.add(customer);
			
		}


		public Customers getCustomers(int start, int size) {
			Customers _customers=new Customers();
			_customers.setCustomers(customers.subList(start, start+size));
			
			return _customers;
		}
		
	
}

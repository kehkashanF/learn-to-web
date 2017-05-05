package com.psl.dao;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.psl.bean.Customer;

@Provider
public class CustomerJAXBContextProvider implements
		ContextResolver<JAXBContext> {
	private JAXBContext context = null;
	
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		if(type!=Customer.class)
			return null;
		if(context == null) {
				try {
				          context = JAXBContext.newInstance(Customer.class);
				 } catch (JAXBException e) {
				                  // log warning/error; null will be returned which indicates that this
				                  // provider won't/can't be used.
				 }
		}
		return context;
			
	}

}

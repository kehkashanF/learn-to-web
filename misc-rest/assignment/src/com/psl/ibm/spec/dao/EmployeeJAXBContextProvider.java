package com.psl.ibm.spec.dao;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.psl.ibm.spec.bean.Employee;



@Provider
public class EmployeeJAXBContextProvider implements
		ContextResolver<JAXBContext> {
	private JAXBContext context = null;
	
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		if(type!=Employee.class)
			return null;
		if(context == null) {
				try {
				          context = JAXBContext.newInstance(Employee.class);
				 } catch (JAXBException e) {

					 	System.out.println("Exception caught!");
				 }
		}
		return context;
			
	}

}

package com.psl.main;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;

public class Main {
			public static void main(String[] args) {
				Contact c1=new Contact("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"));
				
				c1.setAddresses(new HashSet<Address>(Arrays.asList(new Address("nagpur","india"),
							new Address("chicago","USA"), 
								new Address("abu dhabi","uae"))));
				
				c1.setMobileNumbers(new HashSet<String>(Arrays.asList("897868","767286372","76234764")));
				
				
				Contact c2=new Contact("firstName2", "lastName2", 
												Date.valueOf("2002-02-02"));
				
				c2.setAddresses(new HashSet<Address>(Arrays.asList(new Address("tfdfdf","india"),
						new Address("chicfdfsdago","sdfsd"), 
						new Address("abu fdfddhabi","uadfde"))));
				c2.setMobileNumbers(new HashSet<String>(Arrays.asList("0246765","58231247","4512387")));

				Configuration configuration=new AnnotationConfiguration().configure().addAnnotatedClass(Contact.class);
				
				SessionFactory sf=configuration.buildSessionFactory();
				
				Session session = sf.openSession();
				
				Transaction tx = session.beginTransaction();
				
				//insert operation
				session.save(c1);
				session.save(c2);
				
				tx.commit();
				session.close();
				
				sf.close();
			}
}
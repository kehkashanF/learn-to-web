package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Contact;

public class Main {
			@SuppressWarnings("deprecation")
			public static void main(String[] args) {
				Contact c1=new Contact("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"));
				Contact c2=new Contact("firstName2", "lastName2", 
												Date.valueOf("2002-02-02"));

				Configuration conf = new AnnotationConfiguration().configure().addAnnotatedClass(Contact.class);
				SessionFactory sf1=conf.buildSessionFactory();

				Session session1 = sf1.openSession();

				Transaction tx = session1.beginTransaction();
			
				session1.save(c1);  
			    session1.save(c2); 
				
				tx.commit();
				session1.close();
				
				sf1.close();
			}
}

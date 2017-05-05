package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;

public class Main {
			public static void main(String[] args) {
				Contact c1=new Contact("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"), new Address("nagpur", "india"));
				Contact c2=new Contact("firstName2", "lastName2", 
												Date.valueOf("2002-02-02"), new Address("chicago", "USA"));
				

				Configuration configuration=new Configuration().configure();
				
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

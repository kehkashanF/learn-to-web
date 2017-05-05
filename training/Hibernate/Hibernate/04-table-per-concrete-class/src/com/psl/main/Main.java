package com.psl.main;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Employee;
import com.psl.bean.Friend;
import com.psl.bean.Relative;

public class Main {
			public static void main(String[] args) {
				Contact c1=new Relative("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"), new Address("nagpur", "india"),
															"petName1","relation1");
				c1.setContactId(100);
			
				Contact c2=new Friend("firstName2", "lastName2", 
												Date.valueOf("2002-02-02"), new Address("chicago", "USA"),
															"nickName1");
				c2.setContactId(200);
				
				Contact c3=new Employee("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"), new Address("badlapur", "uganda"),
															"EMP_001","designation1");
				c3.setContactId(300);
				Configuration configuration=new Configuration().configure();
				
				SessionFactory sf=configuration.buildSessionFactory();
				 
				Session session = sf.openSession();
				
				Transaction tx = session.beginTransaction();
				
				session.save(c1);
				session.save(c2);
				session.persist(c3);
				tx.commit();
				
				session.clear();
				
				//HQL
				//uses entity class names and property names in lieu of tables and column names
				
				Query query = session.createQuery("from Contact where contactId = ?");
				query.setParameter(0, 200);
				List<Contact> cs = query.list();
				for(Contact c : cs) {
					System.out.println(c.getFirstName());
				}
				
				//polymorphic query
				//Contact c= (Contact)session.get(Contact.class, new Integer(200));
				//System.out.println(c.getFirstName());
				
				session.close();
				
				sf.close();
			}
}

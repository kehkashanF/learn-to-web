package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Contact;

public class Main {
			public static void main(String[] args) {
				Contact c1=new Contact("firstName1", "lastName1", 
												Date.valueOf("2001-01-01"), "fn_ln@gm.com");
				Contact c2=new Contact("firstName2", "lastName2", 
												Date.valueOf("2002-02-02"), "abc.xyz@pqr.com");
				
				
			
				//1. create obj of this class to load all configuration from hibernate.cfg.xml
				Configuration configuration=new Configuration().configure();
				
				//2. Build Session Factory to use this configuration
				SessionFactory sf=configuration.buildSessionFactory();
				
				//3. Build a hibernate session 
				Session session = sf.openSession();
				
				//as soon as openSession() is called AUTO-COMMIT is set to FALSE thus:
				//4. Transaction begins --> all CRUD operations are done within this object and it is mandatory
				Transaction tx = session.beginTransaction();
				
				//insert operation
				session.save(c1);
				session.save(c2);
				tx.commit();
				
				session.clear();
				
				
				//c1.setFirstName("yo firstname1"); //detached
				
				tx=session.beginTransaction();
				//session.persist(c1); not allowed on detached obj
				//session.update(c1); updates a detached obj
				//session.saveOrUpdate(c1); updates a detached obj
				//sesssion.save(c1); tries to insert a new row if object is PERSISTENT
				//if obj is not detached, we dont need to manually update, it happens automatically
				
				Contact retrievedContact=(Contact)session.get(Contact.class, new Integer(1));
				//if ref to obj is present in cache, obj is retrieved from there, else a select query is fired onto the db 
				//and obj is re introduced into the cache
				
				//after this point, a ref to rC exists in cache, and rC obj is created on heap
				//so if we now try to manipulate c1 instead of rC, it gives an error as c1 has same id as rC (non unique)
				//so to avoid conflict use:
				
				c1.setFirstName("yayayaya");
				session.merge(c1);
				
				tx.commit();
				
				session.close();
				
				sf.close();
				 System.out.println(retrievedContact);
				
			}
}

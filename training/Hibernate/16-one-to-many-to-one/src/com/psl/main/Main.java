package com.psl.main;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.User;

public class Main {
			public static void main(String[] args) {
				
				
				User u1 = new User("Drake");
				User u2 = new User("Bono");
				User u3 = new User("Nicki Minaj");
				User u4 = new User("Adele");
				
				
				Contact c1=new Contact("Kehkashan", "Fazal", 
						Date.valueOf("2001-01-01"));
				
				c1.setAddresses(new HashSet<Address>(Arrays.asList(new Address("nagpur","india"),
							new Address("chicago","USA"), 
								new Address("abu dhabi","uae"))));
				
				c1.setMobileNumbers(new HashSet<String>(Arrays.asList("897868","767286372","76234764")));
			
				
				Contact c2=new Contact("Rumana", "Badar", 
												Date.valueOf("2002-02-02"));
				
				c2.setAddresses(new HashSet<Address>(Arrays.asList(new Address("pune","india"),
						new Address("badlapur","uganda"), 
						new Address("abu gharib","saudi gharibiya"))));
				c2.setMobileNumbers(new HashSet<String>(Arrays.asList("0246765","58231247","4512387")));
				
				Contact c3=new Contact("Kim", "Kardashian-West", 
						Date.valueOf("2001-01-01"));
				
				c3.setAddresses(new HashSet<Address>(Arrays.asList(new Address("LA","USA"),
							new Address("asspur","USA"), 
								new Address("boobville","uae"))));
				
				c3.setMobileNumbers(new HashSet<String>(Arrays.asList("897868","767286372","76234764")));
				
				
				Contact c4=new Contact("Donald", "Trump", 
												Date.valueOf("2002-02-02"));
				
				c4.setAddresses(new HashSet<Address>(Arrays.asList(new Address("tfdfdf","india"),
						new Address("toupeville","sdfsd"), 
						new Address("abu oldie","uadfde"))));
				c4.setMobileNumbers(new HashSet<String>(Arrays.asList("0246765","58231247","4512387")));
				
				
				
				Contact c5=new Contact("Benedict", "CabbagePatch", 
						Date.valueOf("2001-01-01"));
				
				c5.setAddresses(new HashSet<Address>(Arrays.asList(new Address("nagpur","india"),
							new Address("sexypur","USA"), 
								new Address("dreamyville","uae"))));
				
				c5.setMobileNumbers(new HashSet<String>(Arrays.asList("897868","767286372","76234764")));
				
				
				Contact c6=new Contact("Robert", "Downey Jr.", 
												Date.valueOf("2002-02-02"));
				
				c6.setAddresses(new HashSet<Address>(Arrays.asList(new Address("tfdfdf","india"),
						new Address("chicfdfsdago","sdfsd"), 
						new Address("abu fdfddhabi","uadfde"))));
				c6.setMobileNumbers(new HashSet<String>(Arrays.asList("0246765","58231247","4512387")));

				
				u1.addContact(c1);
				u1.addContact(c2);
			
				u2.addContact(c3);
					
				u3.addContact(c4);
				u3.addContact(c5);
				u3.addContact(c6);
				
				
				
				Configuration configuration=new Configuration().configure();
				
				SessionFactory sf=configuration.buildSessionFactory();
				
				Session session = sf.openSession();
				
				Transaction tx = session.beginTransaction();
					session.save(u1);
					session.save(u2);
					session.save(u3);
					session.save(u4);
				tx.commit();
				
				session.clear();
				
//				fetch user with some id (id user 1)
//				fetch contact with some id(belongs to user 1)
//				call user.getContacts().remove(contact)
//				begin trans
//				session.saveOrUpdate(user, arg1)
//				end trans
				
//				tx=session.beginTransaction();
//					
//				User user = (User) session.get(User.class, new Integer(1));
//				//System.out.println(user);
//				Contact contact = (Contact) session.get(Contact.class, new Integer(1));
//				//System.out.println(contact);
//				user.getContacts().remove(contact);
//				tx.commit();
//				
//				
//				tx=session.beginTransaction();
//					session.saveOrUpdate(user);
//				tx.commit();
				
				//delete user
//				tx=session.beginTransaction();
//					User user = (User) session.get(User.class, new Integer(1));
//					session.delete(user);
//				tx.commit();
				
				
				//fetch user with some id
				//execute code
				
//				tx=session.beginTransaction();
//						//at this point collection is not loaded (LAZY LOADING)
//						User user = (User) session.get(User.class, new Integer(1)); 
//						//many valued attributes are loaded only when getContacts() is called unless lazy=true
//						System.out.println(user.getContacts());
//						//if we set lazy=extra, it only returns a count of the number of elements in a set
//				tx.commit();
				
				Query query = session.createQuery("from User");
			
				List<User> us = query.list();
				for(User u : us) {
					System.out.println(u.getUsername());
					Set<Contact> cs=u.getContacts();
					for(Contact c : cs)
						System.out.println(c.getFirstName());
					
				}
				
				
				session.close();
				
				sf.close();
			}
}

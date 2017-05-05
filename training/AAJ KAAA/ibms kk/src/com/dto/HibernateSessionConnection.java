package com.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionConnection {

	public Session getSession(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		return factory.openSession();
	}
}

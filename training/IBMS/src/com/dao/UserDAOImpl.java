package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.User;

public class UserDAOImpl implements UserDAO{

	private Session getSessionObject(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		return factory.openSession();
	}
	
	public User getUser(String email){
		
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User where email = ?");
			query.setParameter(0, email);
			List<User> users = query.list();
		// new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
		// be written in the Controller
		for (User us : users) {
				tx.commit();
				session.close();
				return us; //user returns with old password details

		}

		tx.commit();
		session.close();
		return null;
	}
	
	public void editDetails(User user) {
			Session session = getSessionObject();
			Transaction tx = session.beginTransaction();
				session.update(user);
			tx.commit();
			session.close();
	}


}

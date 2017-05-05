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
import com.dto.HibernateSessionConnection;

public class UserDAOImpl implements UserDAO{

	public User getUser(String email){
		
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User where email = ?");
			query.setParameter(0, email);
			List<User> users = query.list();
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
		Session session = new HibernateSessionConnection().getSession();
			Transaction tx = session.beginTransaction();
				session.update(user);
			tx.commit();
			session.close();
	}


}

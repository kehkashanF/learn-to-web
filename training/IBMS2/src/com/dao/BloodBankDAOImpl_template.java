package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bean.BloodBank;


public class BloodBankDAOImpl_template implements BloodBankDAO {

	public void editDetails(BloodBank bloodBank) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(bloodBank);
		tx.commit();
		session.close();
		factory.close();

	}

}

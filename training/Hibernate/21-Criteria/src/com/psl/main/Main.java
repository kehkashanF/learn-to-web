package com.psl.main;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.psl.bean.Account;
import com.psl.bean.User;

public class Main {
	public static void main(String[] args) {
		User u1= new User("Mukesh Ambani");
		User u2= new User("Nitesh Ambani");
		User u3= new User("Kamlesh Ambani");
		User u4= new User("Suresh Ambani");
		User u5= new User("Ramesh Ambani");
		
		u1.addAccounts(new Account(234));
		u1.addAccounts(new Account(455));
		u1.addAccounts(new Account(100));
		
		u2.addAccounts(new Account( 5678));
		u2.addAccounts(new Account( 590));
		u2.addAccounts(new Account( 2222));
		
		
		u3.addAccounts(new Account(234345));
		u3.addAccounts(new Account(734));
		u3.addAccounts(new Account(554));
		

		u4.addAccounts(new Account(8347));
		u4.addAccounts(new Account(7676));
		u4.addAccounts(new Account(5734));

	
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session session=sf.openSession();
				
		Transaction tx=session.beginTransaction();
				session.saveOrUpdate(u1);
				session.saveOrUpdate(u2);
				session.saveOrUpdate(u3);
				session.saveOrUpdate(u4);
				session.saveOrUpdate(u5);
		tx.commit();
		
		session.clear();
		
		
		System.out.println("---------LIST()-----------");
		Criteria criteria = session.createCriteria(User.class);
		List<User> usr_lst = criteria.list();
		for(User u : usr_lst){
			System.out.println(u.getFullName());
		}
		
		System.out.println("----------Restriction------------");
		criteria=session.createCriteria(Account.class);
		criteria.add(Restrictions.gt("balance", 500.0));
		criteria.add(Restrictions.lt("balance", 10000.0));
		List<Account> act_lst = criteria.list();
		for(Account a : act_lst){
			System.out.println(a.getBalance());
		}
		
		System.out.println("----------Create criteria within criteria inception ------------");
		criteria=session.createCriteria(User.class);
		criteria.createCriteria("accounts").add(Restrictions.gt("balance", 5000.0));
		List<User> lst1 = criteria.list();
		for(User a : lst1){
			System.out.println(a.getFullName());
		}
		
		System.out.println("----------Projection------------");
		criteria=session.createCriteria(User.class);
		ProjectionList p1 = Projections.projectionList();
		p1.add(Projections.property("fullName"));
		p1.add(Projections.property("a.balance"));
		criteria.setProjection(p1).createAlias("accounts", "a");
		List<Object[]> arr = criteria.list();
		for(Object[] aiyyo : arr){
			System.out.println(aiyyo[0]+"---"+aiyyo[1]);
		}
		
		System.out.println("----------Aggregation------------");
		criteria=session.createCriteria(User.class);
		p1 = Projections.projectionList();
		p1.add(Projections.property("fullName"));
		p1.add(Projections.sum("a.balance"));
		p1.add(Projections.groupProperty("fullName"));
		criteria.setProjection(p1).createAlias("accounts", "a");
		arr = criteria.list();
		for(Object[] aiyyo : arr){
			System.out.println(aiyyo[0]+"---"+aiyyo[1]);
		}
		session.close();
		sf.close();
	}

}

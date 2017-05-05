package com.psl.main;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Account;
import com.psl.bean.User;

public class Main {
	public static void main(String[] args) {
		User u1= new User("Mukesh Ambani");
		User u2= new User("Nitesh Ambani");
		User u3= new User("Kamlesh Ambani");
		User u4= new User("Suresh Ambani");
		User u5= new User("Ramesh Ambani");
		
		u1.addAccounts(new Account(83475734));
		u1.addAccounts(new Account( 83475734));
		u1.addAccounts(new Account(83475734));
		
		u2.addAccounts(new Account( 83475734));
		u2.addAccounts(new Account( 83475734));
		u2.addAccounts(new Account( 83475734));
		
		
		u3.addAccounts(new Account(83475734));
		u3.addAccounts(new Account(83475734));
		u3.addAccounts(new Account(83475734));
		

		u4.addAccounts(new Account(83475734));
		u4.addAccounts(new Account(83475734));
		u4.addAccounts(new Account(83475734));

	
		
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
		
		Query query=session.createQuery("from User");
		List<User> us = query.list();
		for(User u : us){
			System.out.println(u.getFullName());
		}
		
		
		System.out.println("------NATIVE SQL-----------");
		
		query=session.createSQLQuery("select * from account");
		List<Object[]> obj_arr = query.list();
		
		for(Object [] arr : obj_arr)
		{
			System.out.println(arr[0]+"---"+arr[1]+"---"+arr[2]);
		}
		
		System.out.println("----Pagination----");
		query=session.createQuery("from User");
		query.setFirstResult(0);
		query.setMaxResults(3);
		us = query.list();
		for(User u : us){
			System.out.println(u.getFullName());
		}
		
		System.out.println("-------------------------Named Parameter----------------------");
		
		query=session.createQuery("from Account where balance > :bal");
		query.setInteger("bal", 897349);
		List<Account> as = query.list();
		for(Account a : as){
			System.out.println(a.getBalance());
		}
		
System.out.println("-------------------------External Query----------------------");
//		
//		query=session.getNamedQuery("findBalanceLessThan");
//		query.setInteger("bal", 897349);
//		List<Account> bs = query.list();
//		for(Account a : bs){
//			System.out.println(a.getBalance());
//		}

		query=session.createQuery("from User u where u.accounts is empty");
		List<User> ds = query.list();
		for(User a : ds){
			System.out.println(a.getFullName());
		}
		
//		query=session.createQuery("select u.fullName, a.balance from Account a, User u where a.user.userId=u.userId");
//		List<User> gs = query.list();
//		for(User a : gs){
//			System.out.println(a.getFullName());
//		}
		
		System.out.println("------------Aggregation-------------");
		query=session.createQuery("select u.fullName, sum(a.balance) from User u left outer join u.accounts a group by u.fullName");
		List<Object []> gs = query.list();
		for(Object[] a : gs){
			System.out.println(a[0]+"---"+a[1]);
		}
		session.close();
		sf.close();
	}

}

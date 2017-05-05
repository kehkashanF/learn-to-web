package com.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bean.User;

public class UserDao_Transaction implements UserDAO{
		JdbcTemplate jdbcTemplate;
		private PlatformTransactionManager transactionManager;
	
		public int addUser(User user) {
		int record=0;
		
		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(def);
		
		String SQL_INSERT_CONTACT = "insert into User_Spring values(?,?,?,?,?)";
		try{
			record=jdbcTemplate.update(SQL_INSERT_CONTACT, new Object[] {
				user.getFirstName(), user.getLastName(), user.getGender(), user.getAddress(),	
							user.getEmail()});
			transactionManager.commit(status);
		}catch(DuplicateKeyException e){
			transactionManager.rollback(status);
			System.out.println("Record not inserted");
			//e.printStackTrace();
		}
		return record;
	}

	public User findUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

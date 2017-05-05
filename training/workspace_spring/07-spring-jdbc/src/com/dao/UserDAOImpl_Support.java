package com.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bean.User;

public class UserDAOImpl_Support extends JdbcDaoSupport implements UserDAO{

	public int addUser(User user) {
		int record=0;
		String SQL_INSERT_CONTACT = "insert into User_Spring values(?,?,?,?,?)";
		try{
			record=getJdbcTemplate().update(
					SQL_INSERT_CONTACT, new Object[] {
							user.getFirstName(), user.getLastName(), user.getGender(), user.getAddress(),	
										user.getEmail()}
					);
		}catch(DuplicateKeyException e){
			e.printStackTrace();
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

}

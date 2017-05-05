package com.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.User;

public class UserDAOImpl_template implements UserDAO{

	
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addUser(User user) {
		int record=0;
		String SQL_INSERT_CONTACT = "insert into User_Spring values(?,?,?,?,?)";
		try{
			record=jdbcTemplate.update(SQL_INSERT_CONTACT, new Object[] {
				user.getFirstName(), user.getLastName(), user.getGender(), user.getAddress(),	
							user.getEmail()});
			
		}catch(DuplicateKeyException e){
				e.printStackTrace();
		}
		return record;
	}

	public User findUser(String email) {
		String sql="select firstname, lastname, gender, address, email where email = ?";
		return null;
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;



import com.bean.User;

public class UserDAOImpl implements UserDAO{

	private DataSource dataSource;
	
	public int addUser(User user) {
		int record = 0;
			try {
				Connection connection = dataSource.getConnection();
				PreparedStatement ps=connection.prepareStatement("insert into User_Spring values(?,?,?,?,?)");
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());	
				ps.setInt(3, user.getGender());	
				ps.setString(4, user.getAddress());	
				ps.setString(5, user.getEmail());
				record=ps.executeUpdate();
			} catch (SQLException e) {
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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
		
}

package com.dao;

import java.util.List;

import com.bean.User;


public interface UserDAO {
		public int addUser(User user);
		public User findUser(String email);
		public List<User> findAllUsers();	
}

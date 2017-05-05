package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pojo.User;

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
		String sql="select first_name, last_name, gender, address, email from user_spring where email = ?";
		return (User) jdbcTemplate.queryForObject(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int row_num) throws SQLException{
				User user=new User();
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setAddress(rs.getString(4));
				user.setEmail(rs.getString(5));
				return user;
			}
		},
		email);
		
	}

	public List<User> findAllUsers() {
		String sql="select first_name, last_name, gender, address, email from user_spring";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		List<User> allusers=new ArrayList<User>();
		if(list!= null && !list.isEmpty()){
			for(Map<String, Object> users:list){
				User user=new User();
				Object []ob_arr=new Object[5];
				int i=0;
				for(Iterator<Map.Entry<String,Object>> it=users.entrySet().iterator();it.hasNext();){
					Map.Entry<String, Object> entry=it.next();
					String key=entry.getKey();
					ob_arr[i]=entry.getValue();
					
					i++;
				}
				user.setFirstName((String)ob_arr[0]);
				user.setLastName((String)ob_arr[1]);
				user.setGender((int)(long)(Long)ob_arr[2]);
				user.setAddress((String)ob_arr[3]);
				user.setEmail((String)ob_arr[4]);
				allusers.add(user);
			}
		}
		
		
		return allusers;
	}
	
	public int deleteUser(String email) {
		int record=0;
		String SQL_INSERT_CONTACT = "delete from User_Spring where email=?";
		try{   
			record=jdbcTemplate.update(SQL_INSERT_CONTACT, new Object[] {email});
			
		}catch(DuplicateKeyException e){
				e.printStackTrace();
		}
		return record;
	}

}

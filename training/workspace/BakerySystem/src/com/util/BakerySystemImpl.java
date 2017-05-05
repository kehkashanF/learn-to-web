package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bean.Items;
import com.bean.Role;
import com.bean.User;
import com.bean.delOption;
import com.exceptions.UserNotFound;
import com.exceptions.ValidateException;

public class BakerySystemImpl implements BakerySystem {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	DataManager dm = new DataManagerImpl();
	//List<Items> itemList = new ArrayList<Items>();


	@Override
	public List<Items> populateItems() {
		List<Items> itemList = new ArrayList<Items>();
		try {
			
			con = dm.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from items");
			while (rs.next()) {
				Items i = new Items(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getFloat(4), rs.getDate(5),
						delOption.valueOf(rs.getString(6)));
				itemList.add(i);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		} 

		return itemList;
	}

	public User validateUser() {
		User user=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String email = null;
		String pwd = null;
		DataManager dm = new DataManagerImpl();
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs;
		try {
			con = dm.getConnection();
			System.out.println("Enter email: ");
			email = br.readLine();
			System.out.println("Password: ");
			pwd = br.readLine();
			sql = "select * from user where email = ?  AND pass_word = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("Welcome " + rs.getString(2));
				user=new User(rs.getInt(1),Role.valueOf(rs.getString(7)),rs.getString(5),rs.getString(2),rs.getString(4),rs.getString(6));
				/*if (rs.getString(7) == "Admin") {

					// redirect to admin menu here
				} else {
					// redirect to user here
				}*/
				
			} else
				throw new UserNotFound(
						"Email or Password is wrong! No such user exists!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (UserNotFound e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public void register() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the name");
		String name = null;
		try {
			name = br.readLine();
			if (name == null)
				throw new ValidateException("Name cannot be null");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ValidateException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the email id");
		String email = null;
		try {
			email = br.readLine();
			String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			if (!email.matches(regex))
				throw new ValidateException("Format is ABC@XYZ.com");
		} catch (ValidateException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String password = null;
		System.out.println("enter the password");
		try {
			password = br.readLine();
			if (password == null)
				throw new ValidateException("password cannot be null");

			String sql = "insert into user (name, address, phoneno, email, pass_word, role) values ('"
					+ name
					+ "', NULL, NULL, '"
					+ email
					+ "', '"
					+ password
					+ "', 'User');";
			int x = stmt.executeUpdate(sql);
			if (x == 1)
				System.out.println("done");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return null;

	}

	


	@Override
	public void displayMenu(List<Items> itemList) {
		// TODO Auto-generated method stub
		System.out.println("\n\n*****Bihar Bakery System*****");
		System.out.println("\n");
		Iterator<Items> it = itemList.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}

		
	}

	

	}
	
	




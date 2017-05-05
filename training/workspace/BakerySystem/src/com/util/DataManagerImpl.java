package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManagerImpl implements DataManager{

	Connection con;
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		final String DB_URL="jdbc:mysql://localhost:3306/bakerysystem";
		final String USER="root";
		final String PASSWORD="root";
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		con=DriverManager.getConnection(DB_URL, USER, PASSWORD);
		return con;
	}

	@Override
	public void closeConnection() throws SQLException {
		
		con.close();
	}

}

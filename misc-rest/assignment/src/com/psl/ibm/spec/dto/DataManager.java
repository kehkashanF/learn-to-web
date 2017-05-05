package com.psl.ibm.spec.dto;

import java.sql.Connection;
import java.sql.SQLException;


public interface DataManager {
		public Connection getConnection() throws ClassNotFoundException, SQLException;
		public void closeConnection() throws SQLException;
}

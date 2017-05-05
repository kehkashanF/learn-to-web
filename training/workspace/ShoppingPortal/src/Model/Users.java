package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;



public class Users extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String name;
	private String email;
	private String phoneNo;
	private String password;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(String name, String email, String phoneNo,
			String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", email="
				+ email + ", phoneNo=" + phoneNo + ", password=" + password
				+ "]";
	}
	
	public boolean storeUser(){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql = "insert into user (name, address, phoneno, email, pass_word) values (?,?,?,?,?);";
			int x = pst.executeUpdate(sql);
			if (x>0)
				return true;
			else
				return false;
				

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean verify(String uname, String pwd){
		
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
		
			sql = "select * from user where email = ?  AND pass_word = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if(rs.next())
				return true;
			else
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}

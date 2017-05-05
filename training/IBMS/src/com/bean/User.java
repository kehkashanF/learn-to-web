package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	@Column(unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private int role; //0-->HOSPITAL; 1-->BloodBank
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password, int role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
}

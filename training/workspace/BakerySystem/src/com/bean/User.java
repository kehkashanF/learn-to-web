package com.bean;

public class User {
	private int userId;
	private Role role;
	private String email;
	private String name;
	private String phoneNo;
	private String password;
	
	public User(int userId, Role role, String email, String name,
			String phoneNo, String password) {
		super();
		this.userId = userId;
		this.role = role;
		this.email = email;
		this.name = name;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "User \n userId: " + userId + "\n role=" + role + "\n email=" + email
				+ "\n name=" + name + "\n phoneNo=" + phoneNo + "\n password="
				+ password;
	}
	
	
	
}

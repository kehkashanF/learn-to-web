package com.bean;

public class Admin {
	private int adminId;
	private Role role;
	private String email, name, password;

	public Admin(int adminId, Role role, String email, String name,
			String password) {
		super();
		this.adminId = adminId;
		this.role = role;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", name="
				+ name + ", password=" + password + "]";
	}

}

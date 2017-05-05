package com.bean;

public class Employee {
	private int empId;
	private String empName;
	private MyDate empJoinDate;
	private Address empAddress;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, MyDate empJoinDate,
			Address empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empJoinDate = empJoinDate;
		this.empAddress = empAddress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public MyDate getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(MyDate empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empJoinDate=" + empJoinDate + ", empAddress="
				+ empAddress + "]";
	}
	
}

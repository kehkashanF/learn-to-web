package com.psl.pojo;

public class Student {
	private int rollNo;
	private String name;
	private int std;
	
	public Student() {

	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStd() {
		return std;
	}

	

	public void setStd(int std) {
		this.std = std;
	}
	
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", std=" + std
				+ "]";
	}
	
}

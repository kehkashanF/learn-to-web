package com.wiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Student {
	@Value(value="Kehkashan")
	private String name;
	@Value(value="10")
	private int rollNo;
	@Autowired(required=true) //this obj is compusorily reqd --> by deafault it is autowired by Name
	@Qualifier(value="add") //to specify which name of the autowired obj to use from the bean tag
	private Address address;
	
	public Student() {
//		this.name = "Kehku";
//		this.rollNo = 215;
	}
	
	public Student(String name, int rollNo, Address address) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void sayGreeting(){
		System.out.println("Hello "+ name);
		System.out.println(address);
	}
	
}

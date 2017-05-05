package com.psl.ibm.spec.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class Employees {

	private List<Employee> employees;

	public Employees() {
	}

	@XmlElementRef
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

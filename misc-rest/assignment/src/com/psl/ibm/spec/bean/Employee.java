package com.psl.ibm.spec.bean;


import javax.validation.constraints.NotNull;
import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.psl.ibm.spec.exceptions.EmployeeException;

@XmlRootElement(name = "employee")
public class Employee  {
	private int empId;
	private String empName;
	private int empAge;
	private Designation designation;
	private AtomLink self;

	private boolean isAlpha(String name) {
		return name.matches("[a-zA-Z]+");
	}

	public Employee() {
	}

	public Employee(int empId, String empName, int empAge, Designation designation) throws EmployeeException {
		super();
		try {
			setEmpId(empId);
			setEmpName(empName);
			setEmpAge(empAge);
			setDesignation(designation);
		} catch (ValidationException e) {
//			List<String> error = new ArrayList<String>();
//			error.add(e.getMessage());
//			throw new EmployeeException(error);
			
			      throw new IllegalArgumentException(e);
			    
		} 
	}

	@NotNull
	@XmlAttribute(name = "empId")
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) throws ValidationException {
		if (empId < 1) {
			throw new ValidationException("Quantity value must be positive, but is: " + empId);
		}
		this.empId = empId;
	}

	@NotNull
	@XmlElement(name = "empName")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) throws ValidationException {
		if (!isAlpha(empName)) {
			throw new ValidationException("Name cannot contain numbers!");
		}

		this.empName = empName;
	}

	@NotEmpty
	@XmlElement(name = "empAge")
	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) throws ValidationException {
		if (empAge < 1 || empAge > 99) {
			throw new ValidationException("Employee cannot be " + empAge
					+ " years old!");
		}
		this.empAge = empAge;
	}

	@NotNull
	@XmlElement(name = "designation")
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) throws ValidationException {
		this.designation = designation;
	}

	@XmlElementRef
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empAge=" + empAge + ", designation=" + designation + "]";
	}

	
}

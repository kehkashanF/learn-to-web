package com.psl.ibm.spec.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

@XmlRootElement(name = "employee")
public class Employee {
	@DecimalMin(value = "1")
	private int empId;

	private String empName;

	@DecimalMin(value = "1")
	@DecimalMax(value = "99")
	private int empAge;

	private Designation designation;

	private AtomLink self;

	public Employee() {
	}

	public Employee(int empId, String empName, int empAge,
			Designation designation) {
		super();

		setEmpId(empId);
		setEmpName(empName);
		setEmpAge(empAge);
		setDesignation(designation);

	}

	@XmlAttribute(name = "empId")
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@XmlElement(name = "empName")
	@NotNull(message = "{employee.null.name}")
	@Pattern(message = "{employee.wrong.name}", regexp = "	[a-zA-Z]+\\.?")
	@Length(min = 2, max = 20)
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {

		this.empName = empName;
	}

	@XmlElement(name = "empAge")
	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@XmlElement(name = "designation")
	@NotNull(message = "{employee.null.designation}")
	@Pattern(message = "{employee.wrong.designation}", regexp = "(SOFTWARE_ENG|MODULE_LEAD|TEAM_LEAD|PROJ_MGR)")
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
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

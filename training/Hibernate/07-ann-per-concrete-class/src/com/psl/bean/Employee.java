package com.psl.bean;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_TBL")
@AttributeOverrides({
    @AttributeOverride(name="firstName", column=@Column(name = "first_name")),
    @AttributeOverride(name="lastName", column=@Column(name = "last_name")),
    @AttributeOverride(name="dateOfBirth", column=@Column(name = "dob")),
    @AttributeOverride(name="address", column=@Column(name = "address"))
})
public class Employee extends Contact{
	@Column(name = "empCode")
		private String empCode;
	@Column(name = "designation")
		private String designation;
		
		
		public Employee() {
			super();
		}
		public Employee(String firstName, String lastName, Date dateOfBirth,
				Address address, String empCode, String designation) {
			super(firstName, lastName, dateOfBirth, address);
			this.empCode = empCode;
			this.designation = designation;
		}

		public String getEmpCode() {
			return empCode;
		}

		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}
		
		
}
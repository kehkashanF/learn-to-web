package com.psl.bean;

import java.sql.Date;

public class Employee extends Contact{
		private String empCode, designation;
		
		
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

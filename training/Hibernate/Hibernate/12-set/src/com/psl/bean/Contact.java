package com.psl.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact { //entity class
		private int contactId;
		private String firstName, lastName;
		private Date dateOfBirth;
		private Address address;
		private Set<String> mobileNumbers=new HashSet<String>();
		public Contact() {
		}
		
		
		public Contact(String firstName, String lastName,
				Date dateOfBirth, Address address) {
			super();
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.address=address;
		}


		public int getContactId() {
			return contactId;
		}
		public void setContactId(int contactId) {
			this.contactId = contactId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}


		public void setAddress(Address address) {
			this.address = address;
		}


		public Address getAddress() {
			return address;
		}


		public void setMobileNumbers(Set<String> mobileNumbers) {
			this.mobileNumbers = mobileNumbers;
		}


		public Set<String> getMobileNumbers() {
			return mobileNumbers;
		}


	
		
		
}

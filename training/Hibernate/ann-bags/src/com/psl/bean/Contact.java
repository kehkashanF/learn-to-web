package com.psl.bean;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Contact { //entity class
	
		@Id
		@GeneratedValue
		private int contactId;
		private String firstName, lastName;
		private Date dateOfBirth;
		private Address address;
		//bag is a collection of unordered values that can have duplicates (SET+ARRAY) --> specific to hibernate
		
		@ElementCollection
		
		private Collection<String> mobileNumbers=new ArrayList<String>();
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


		public void setMobileNumbers(Collection<String> mobileNumbers) {
			this.mobileNumbers = mobileNumbers;
		}


		public Collection<String> getMobileNumbers() {
			return mobileNumbers;
		}






	
		
		
}

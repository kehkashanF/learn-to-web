package com.psl.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table
public class Contact { //entity class
		@Id
		@GeneratedValue
		private int contactId;
		private String firstName, lastName;
		private Date dateOfBirth;
		@Embedded
		private Address address;
		
		@ElementCollection
		@CollectionTable(name="mobile_numbers_set_table", joinColumns=@JoinColumn(name="contact_id_fk") )
		@Column(name="mobile_numbers")
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

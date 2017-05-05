package com.psl.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Contact { //entity class
		@Id
		@Column(name = "contact_id")
		private int contactId;
		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		@Column(name = "dob")
		private Date dateOfBirth;
		
		@Embedded
		private Address address;
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
		
		
}

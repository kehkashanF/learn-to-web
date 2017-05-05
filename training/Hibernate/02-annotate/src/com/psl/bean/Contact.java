package com.psl.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="ann_contacts")
public class Contact { //entity class
	
		@Id 
		@GeneratedValue
		@Column(name = "contact_id")
		private int contactId;
		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		@Column(name = "dob")
		private Date dateOfBirth;
		
		
		
		public Contact() {
		}
		
		
		public Contact(String firstName, String lastName,
				Date dateOfBirth) {
			super();
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
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
		@Override
		public String toString() {
			return "Contact [contactId=" + contactId + ", dateOfBirth="
					+ dateOfBirth + ", firstName=" + firstName + ", lastName="
					+ lastName + "]";
		}
		
		
}

package com.psl.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="tbl_select")
public class Contact { //entity class
		
		@Id
		@GenericGenerator(name = "email", strategy = "increment")
		@GeneratedValue(generator = "email")
		private int contactId;
		@Column
		private String firstName;
		@Column
		private String lastName;
		@Column
		private Date dateOfBirth;
		
		@Column(name="email", unique=true )
		private String email;
		public Contact() {
		}
		
		
		public Contact(String firstName, String lastName,
				Date dateOfBirth, String email) {
			super();
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			
			this.email=email;
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
					+ lastName + ", email = " + email+"]";
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getEmail() {
			return email;
		}
		
		
}

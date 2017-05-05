package com.psl.bean;

import java.sql.Date;

public class Contact { //entity class
		private int contactId;
		private String firstName, lastName;
		private Date dateOfBirth;
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

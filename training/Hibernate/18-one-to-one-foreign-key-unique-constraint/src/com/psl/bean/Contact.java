package com.psl.bean;

import java.sql.Date;

import java.util.HashSet;

import java.util.Set;

public class Contact { //entity class
		private int contactId;
		private String firstName, lastName;
		private Date dateOfBirth;
		private Set<Address> addresses = new HashSet<Address>();
		private Set<String> mobileNumbers=new HashSet<String>();
		//Many Contacts might belong to one User(ID) --> MANY TO ONE RELATION
		User user;
		private Profile profile;
		
		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


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


		
		public void setAddresses(Set<Address> addresses) {
			this.addresses = addresses;
		}


		public Set<Address> getAddresses() {
			return addresses;
		}


		public void setMobileNumbers(Set<String> mobileNumbers) {
			this.mobileNumbers = mobileNumbers;
		}


		public Set<String> getMobileNumbers() {
			return mobileNumbers;
		}


		public Profile getProfile() {
			return profile;
		}


		public void setProfile(Profile profile) {
			this.profile = profile;
		}


		public void addProfile(Profile profile){
			setProfile(profile);
			profile.setContact(this);
			
		}

		
	
		
		
}

package com.psl.bean;

import java.util.HashSet;
import java.util.Set;



public class User {
		private int userId;
		private String username;
		//one User has MANY contacts --> ONE TO MANY RELATION
		private Set<Contact> contacts=new HashSet<Contact>();
		
		public User() {
	
		}
		public User(String username) {
			this.username = username;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Set<Contact> getContacts() {
			return contacts;
		}
		public void setContacts(Set<Contact> contacts) {
			this.contacts = contacts;
		}
		
		
		//utility function for automatically setting contacts to a particular list and setting correct UserId for contacts
		public void addContact(Contact contact){
			getContacts().add(contact); //fetches the set and adds the particular Contact to it
			contact.setUser(this);	//using the contact object fetches the user and sets it to current user
		}
		
}

package com.psl.bean;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="customer")
// to apply on field --> @XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
		private int customerId;
		private String firstName, lastName;
		private AtomLink self;
		
		public Customer() {
		}
		
		
		public Customer(int customerId, String firstName, String lastName) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@XmlAttribute(name="id")
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		@XmlElement(name="first-name")
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		@XmlElement(name="last-name")
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@XmlElementRef
		public AtomLink getSelf() {
			return self;
		}


		public void setSelf(AtomLink self) {
			this.self = self;
		}


		@Override
		public String toString() {
			return "Customer [customer=" + customerId + ", firstName="
					+ firstName + ", lastName=" + lastName + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + customerId;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (customerId != other.customerId)
				return false;
			return true;
		}
		
		
		
}

package com.psl.bean;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
		private String city, country;
		
		public Address() {
			// TODO Auto-generated constructor stub
		}

		public Address(String city, String country) {
			super();
			this.city = city;
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
		
		
		
}

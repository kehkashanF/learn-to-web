package com.psl.bean;

import java.sql.Date;

public class Relative extends Contact{
		private String petName, relation;

		public Relative() {
				super();
		}
		
		public Relative(String firstName, String lastName, Date dateOfBirth,
				Address address, String petName, String relation) {
			super(firstName, lastName, dateOfBirth, address);
			this.petName = petName;
			this.relation = relation;
		}

		public String getPetName() {
			return petName;
		}

		public void setPetName(String petName) {
			this.petName = petName;
		}

		public String getRelation() {
			return relation;
		}

		public void setRelation(String relation) {
			this.relation = relation;
		}
	
		
}

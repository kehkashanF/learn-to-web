package com.psl.bean;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="RELATIVE_TBL")
@PrimaryKeyJoinColumn(name = "contact_id")
public class Relative extends Contact{
	@Column(name = "pet_name")	
	private String petName;
	
	@Column(name = "relation")
	private String relation;

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

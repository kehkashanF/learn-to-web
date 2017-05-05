package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitals")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int hospital_id;
	@Column(name = "name")
	private String hospital_name;
	@Column(name = "address")
	private String hospital_address;
	@Column(name = "pinCode")
	private int hospital_pin;
	@Column(name = "password")
	private String hospital_password;
	@Column(name = "lisenceNO", unique = true)
	private String hospital_lisenceNo;
	@Column(name = "officer_name")
	private String officer_name;
	@Column(name = "emailId" , unique = true)
	private String hospital_email;
	@Column(name = "certification")
	private String hospital_certification;
	@Column(name = "contactNo" , unique = true)
	private String hospital_contactNo;
	public Hospital(String hospital_name, String hospital_address,
			int hospital_pin, String hospital_password,
			String hospital_lisenceNo, String officer_name,
			String hospital_email, String hospital_certification,
			String hospital_contactNo) {
		super();
		this.hospital_name = hospital_name;
		this.hospital_address = hospital_address;
		this.hospital_pin = hospital_pin;
		this.hospital_password = hospital_password;
		this.hospital_lisenceNo = hospital_lisenceNo;
		this.officer_name = officer_name;
		this.hospital_email = hospital_email;
		this.hospital_certification = hospital_certification;
		this.hospital_contactNo = hospital_contactNo;
	}

	public Hospital() {
		super();
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public int getHospital_pin() {
		return hospital_pin;
	}

	public void setHospital_pin(int hospital_pin) {
		this.hospital_pin = hospital_pin;
	}

	public String getHospital_password() {
		return hospital_password;
	}

	public void setHospital_password(String hospital_password) {
		this.hospital_password = hospital_password;
	}

	public String getHospital_lisenceNo() {
		return hospital_lisenceNo;
	}

	public void setHospital_lisenceNo(String hospital_lisenceNo) {
		this.hospital_lisenceNo = hospital_lisenceNo;
	}

	public String getOfficer_name() {
		return officer_name;
	}

	public void setOfficer_name(String officer_name) {
		this.officer_name = officer_name;
	}

	public String getHospital_email() {
		return hospital_email;
	}

	public void setHospital_email(String hospital_email) {
		this.hospital_email = hospital_email;
	}

	public String getHospital_certification() {
		return hospital_certification;
	}

	public void setHospital_certification(String hospital_certification) {
		this.hospital_certification = hospital_certification;
	}

	public String getHospital_contactNo() {
		return hospital_contactNo;
	}

	public void setHospital_contactNo(String hospital_contactNo) {
		this.hospital_contactNo = hospital_contactNo;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_name="
				+ hospital_name + ", hospital_address=" + hospital_address
				+ ", hospital_pin=" + hospital_pin + ", hospital_password="
				+ hospital_password + ", hospital_lisenceNo="
				+ hospital_lisenceNo + ", officer_name=" + officer_name
				+ ", hospital_email=" + hospital_email
				+ ", hospital_certification=" + hospital_certification
				+ ", hospital_contactNo=" + hospital_contactNo + "]";
	}

}

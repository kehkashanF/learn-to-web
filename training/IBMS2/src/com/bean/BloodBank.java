package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blood_banks")
public class BloodBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int bloodBank_id;
	@Column(name = "name")
	private String bloodBank_name;
	@Column(name = "address")
	private String bloodBank_address;
	@Column(name = "pinCode")
	private int bloodBank_pin;
	@Column(name = "circle")
	private String bloodBank_circle;
	@Column(name = "telephone_no", unique = true)
	private String bloodBank_telephoneNo;
	@Column(name = "mobile_no", unique = true)
	private String bloodBank_mobileNo;
	@Column(name = "FDA_lisenceNo", unique = true)
	private String FDA_lisenceNo;
	@Column(name = "BTO_name")
	private String BTO_name;
	@Column(name = "functional")
	private boolean functional;
	@Column(name = "emailId", unique = true)
	private String bloodBank_emailId;
	@Column(name = "password")
	private String bloodBank_password;
	@Column(name = "url")
	private String bloodBank_url;
	@Column(name = "restBaseUrl")
	private String bloodBank_rest_url;

	public BloodBank(String bloodBank_name, String bloodBank_address,
			int bloodBank_pin, String bloodBank_circle,
			String bloodBank_telephoneNo, String bloodBank_mobileNo,
			String fDA_lisenceNo, String bTO_name, boolean functional,
			String bloodBank_emailId, String bloodBank_password,
			String bloodBank_url, String bloodBank_rest_url) {
		super();
		this.bloodBank_name = bloodBank_name;
		this.bloodBank_address = bloodBank_address;
		this.bloodBank_pin = bloodBank_pin;
		this.bloodBank_circle = bloodBank_circle;
		this.bloodBank_telephoneNo = bloodBank_telephoneNo;
		this.bloodBank_mobileNo = bloodBank_mobileNo;
		FDA_lisenceNo = fDA_lisenceNo;
		BTO_name = bTO_name;
		this.functional = functional;
		this.bloodBank_emailId = bloodBank_emailId;
		this.bloodBank_password = bloodBank_password;
		this.bloodBank_url = bloodBank_url;
		this.bloodBank_rest_url = bloodBank_rest_url;
	}

	public BloodBank() {
		super();
	}

	

	public int getBloodBank_id() {
		return bloodBank_id;
	}

	public void setBloodBank_id(int bloodBankId) {
		bloodBank_id = bloodBankId;
	}

	public String getBloodBank_name() {
		return bloodBank_name;
	}

	public void setBloodBank_name(String bloodBankName) {
		bloodBank_name = bloodBankName;
	}

	public String getBloodBank_address() {
		return bloodBank_address;
	}

	public void setBloodBank_address(String bloodBankAddress) {
		bloodBank_address = bloodBankAddress;
	}

	public int getBloodBank_pin() {
		return bloodBank_pin;
	}

	public void setBloodBank_pin(int bloodBankPin) {
		bloodBank_pin = bloodBankPin;
	}

	public String getBloodBank_circle() {
		return bloodBank_circle;
	}

	public void setBloodBank_circle(String bloodBankCircle) {
		bloodBank_circle = bloodBankCircle;
	}

	public String getBloodBank_telephoneNo() {
		return bloodBank_telephoneNo;
	}

	public void setBloodBank_telephoneNo(String bloodBank_telephoneNo) {
		this.bloodBank_telephoneNo = bloodBank_telephoneNo;
	}

	public String getBloodBank_mobileNo() {
		return bloodBank_mobileNo;
	}

	public void setBloodBank_mobileNo(String bloodBank_mobileNo) {
		this.bloodBank_mobileNo = bloodBank_mobileNo;
	}

	public String getFDA_lisenceNo() {
		return FDA_lisenceNo;
	}

	public void setFDA_lisenceNo(String fDALisenceNo) {
		FDA_lisenceNo = fDALisenceNo;
	}

	public String getBTO_name() {
		return BTO_name;
	}

	public void setBTO_name(String bTOName) {
		BTO_name = bTOName;
	}

	public boolean isFunctional() {
		return functional;
	}

	public void setFunctional(boolean functional) {
		this.functional = functional;
	}

	public String getBloodBank_emailId() {
		return bloodBank_emailId;
	}

	public void setBloodBank_emailId(String bloodBankEmailId) {
		bloodBank_emailId = bloodBankEmailId;
	}

	public void setBloodBank_url(String bloodBank_url) {
		this.bloodBank_url = bloodBank_url;
	}

	public void setBloodBank_rest_url(String bloodBank_rest_url) {
		this.bloodBank_rest_url = bloodBank_rest_url;
	}

	public String getBloodBank_url() {
		return bloodBank_url;
	}

	public String getBloodBank_rest_url() {
		return bloodBank_rest_url;
	}

	public String getBloodBank_password() {
		return bloodBank_password;
	}

	public void setBloodBank_password(String bloodBank_password) {
		this.bloodBank_password = bloodBank_password;
	}

}

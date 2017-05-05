package com.psl.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Donors")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int donor_id;
	@Column(name = "name")
	private String donorName;
	@Column(name = "date_of_birth")
	private Date date_of_birth;
	@Column(name = "gender")
	private String gender;
	@Column(name = "bloodGroup")
	private BloodGroup bloodGroup;
	@Column(name = "emailId", unique = true)
	private String emailId;
	@Column(name = "contactNo")
	private String contactNo;
	@Column(name = "address")
	private String donorAddress;
	@Column(name = "city")
	private String city;
	@Column(name = "lastDonation_date")
	private Date lastDonationDate;

	public Donor() {
		super();
	}

	public Donor(String donorName, Date date_of_birth, String gender,
			BloodGroup bloodGroup, String emailId, String contactNo,
			String donorAddress, String city, Date lastDonationDate) {
		super();
		this.donorName = donorName;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.donorAddress = donorAddress;
		this.city = city;
		this.lastDonationDate = lastDonationDate;
	}

	public int getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDonorAddress() {
		return donorAddress;
	}

	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getLastDonationDate() {
		return lastDonationDate;
	}

	public void setLastDonationDate(Date lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}

	

}

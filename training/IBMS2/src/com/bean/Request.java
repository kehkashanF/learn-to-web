package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int requestId;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "doctor_name")
	private String doctor_name;
	@Column(name = "bloodGroup")
	private BloodGroup bloodgroup;
	@Column(name = "delivery_date_time")
	private String delivery_date_time;
	@Column(name = "quantity_required")
	private int quantity_required;
	@Column(name = "quantity_received")
	private int quantity_received;
	@Column(name = "status")
	private int status;
	// pending = 1
	// confirmed = 2
	// dispatched = 3
	// cancelled = 4
	// completed = 5
	@Column(name = "bloodType")
	private BloodType bloodType;
	@OneToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
	@OneToOne
	@JoinColumn(name = "bloodBank_id")
	private BloodBank bloodBank;

	public Request() {
		super();
	}

	public Request(String patientName, String doctorName,
			BloodGroup bloodgroup, String deliveryDateTime,
			int quantityRequired, int quantityReceived, int status,
			BloodType bloodType, Hospital hospital, BloodBank bloodBank) {
		super();
		patient_name = patientName;
		doctor_name = doctorName;
		this.bloodgroup = bloodgroup;
		delivery_date_time = deliveryDateTime;
		quantity_required = quantityRequired;
		quantity_received = quantityReceived;
		this.status = status;
		this.bloodType = bloodType;
		this.hospital = hospital;
		this.bloodBank = bloodBank;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patientName) {
		patient_name = patientName;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctorName) {
		doctor_name = doctorName;
	}

	public BloodGroup getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(BloodGroup bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getDelivery_date_time() {
		return delivery_date_time;
	}

	public void setDelivery_date_time(String deliveryDateTime) {
		delivery_date_time = deliveryDateTime;
	}

	public int getQuantity_required() {
		return quantity_required;
	}

	public void setQuantity_required(int quantityRequired) {
		quantity_required = quantityRequired;
	}

	public int getQuantity_received() {
		return quantity_received;
	}

	public void setQuantity_received(int quantityReceived) {
		quantity_received = quantityReceived;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}

}

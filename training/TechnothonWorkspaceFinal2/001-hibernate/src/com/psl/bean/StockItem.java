package com.psl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_item")
public class StockItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int bloodId;
	@Column(name = "blood_Group")
	private BloodGroup bloodGroup;
	@Column(name = "blood_Type")
	private BloodType bloodType;
	@Column(name = "quantity")
	private int quantity;

	public StockItem() {
		super();
	}

	public StockItem(BloodGroup bloodGroup, BloodType bloodType,
			int quantity) {
		super();
		this.bloodGroup = bloodGroup;
		this.bloodType = bloodType;
		this.quantity = quantity;
	}

	public int getBloodId() {
		return bloodId;
	}

	public void setBloodId(int bloodId) {
		this.bloodId = bloodId;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockItem [bloodId=" + bloodId + ", bloodGroup=" + bloodGroup
				+ ", bloodType=" + bloodType + ", quantity=" + quantity + "]";
	}
	

}

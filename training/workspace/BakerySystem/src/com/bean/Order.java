package com.bean;

import java.util.Date;

public class Order {
	private int id;
	private String receipt;
	private double amount;
	private Status status;
	private Date delDate;
	public Order() {
		//super();
		status= Status.pending;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", receipt=" + receipt + ", amount="
				+ amount + ", status=" + status + ", date=" + delDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDate() {
		return delDate;
	}
	public void setDate(Date date) {
		this.delDate = date;
	}
	
	

}

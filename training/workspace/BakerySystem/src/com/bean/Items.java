
package com.bean;

import java.sql.Date;



public class Items implements Comparable<Items>{
	
	private int itemId;
	private String name;
	private int quantity;
	private float price;
	private Date mfgDate;
	private delOption deliveryType;
	
	public Items(int itemId, String name, int quantity, float price,
			Date mfgDate, delOption deliveryType) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.mfgDate = mfgDate;
		this.deliveryType = deliveryType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	public delOption getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(delOption deliveryType) {
		this.deliveryType = deliveryType;
	}
	@Override
	public String toString() {
		return "\n Item Id = " + itemId + "\nName=" + name + "\nQuantity="
				+ quantity + "\nPrice=" + price + "\nMfg Date=" + mfgDate
				+ "\nDelivery Type=" + deliveryType + "\n";
	}

	@Override
	public int compareTo(Items o) {
		Float f1=new Float(this.price);
		Float f2=new Float(o.getPrice());
		int lastCmp = f1.compareTo(f2);
        return (lastCmp != 0 ? lastCmp : f1.compareTo(f2));
	}
	
	

}

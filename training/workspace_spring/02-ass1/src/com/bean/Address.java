package com.bean;

public class Address {
		private String area;
		private String state;
		
		public Address() {
			// TODO Auto-generated constructor stub
		}

		public Address(String area, String state) {
			super();
			this.area = area;
			this.state = state;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String toString() {
			return "Address [area=" + area + ", state=" + state + "]";
		}
		
		
		
}

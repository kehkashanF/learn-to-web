package com.psl.setter_ref;

public class Student_ref {
		private String name;
		private Address address;
		
		public Student_ref() {
			// TODO Auto-generated constructor stub
		}

		
		public Student_ref(String name, Address address) {
			super();
			this.name = name;
			this.address = address;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String toString() {
			return "Student_ref [name=" + name + ", address=" + address + "]";
		}
		
		
}
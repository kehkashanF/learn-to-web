package com.bean;

import org.springframework.stereotype.Component;

@Component(value="abc") //if value not specified de-capitalisation happens and class name is set as id (myStudent)
public class MyStudent {
		private int rollNo;
		private String name;
		
		public MyStudent() {
			this.rollNo = 101;
			this.name = "Kehkashan";
		}

		public MyStudent(int rollNo, String name) {
			super();
			this.rollNo = rollNo;
			this.name = name;
		}

		public int getRollNo() {
			return rollNo;
		}

		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return "MyStudent [rollNo=" + rollNo + ", name=" + name + "]";
		}
		
		
}

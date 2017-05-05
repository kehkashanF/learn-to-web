package com.bean;

public class MyDate {
		private String day, month, year;
		
		public MyDate() {
			// TODO Auto-generated constructor stub
		}

		public MyDate(String day, String month, String year) {
			super();
			this.day = day;
			this.month = month;
			this.year = year;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String toString() {
			return day + "/" + month + "/" + year;
		}
		
		
}

package com.psl.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="show")
public class Show {
		private int showId;
		private String day;
		private String time;
		private int seats;
		
		public Show() {
			// TODO Auto-generated constructor stub
		}
		
		public Show(int showId, String day, String time, int seats) {
			super();
			this.showId=showId;
			this.day = day;
			this.time = time;
			this.seats = seats;
		}

		
		@XmlAttribute(name="showId")
		public int getId() {
			return showId;
		}

		public void setId(int id) {
			this.showId = id;
		}
		
		@XmlElement(name="day")
		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		@XmlElement(name="time")
		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		@XmlElement(name="seats")
		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}

		
		
		
			
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + showId;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Show other = (Show) obj;
			if (showId != other.showId)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Show [id=" + showId + ", day=" + day + ", time=" + time
					+ ", seats=" + seats + "]";
		}

		
		
		
		
		
}

package com.psl.pojo;

public class Student_Constructor {
		private int studId;
		private String studName;
		
		public Student_Constructor(int studId, String studName) {
			super();
			this.studId = studId;
			this.studName = studName;
		}

		public String toString() {
			return "Student_Constructor [studId=" + studId + ", studName="
					+ studName + "]";
		}
		
}

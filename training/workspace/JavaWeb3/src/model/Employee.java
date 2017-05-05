package model;

public class Employee {
		private int empId;
		private String name;
		public Employee() {
			System.out.println("Object created...");
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
}

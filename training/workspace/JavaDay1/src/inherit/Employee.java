package inherit;

public class Employee extends Person {
		private int empId;
		private String designation;
		public Employee(String name, String address, int empId, String designation)
		{
			super(name, address);
			this.empId=empId;
			this.designation=designation;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		
}

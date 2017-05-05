
public class Employye {
	int Empno;
	String Empname;
	String address;
	
	public Employye(int empno, String empname, String address) {
		super();
		Empno = empno;
		Empname = empname;
		this.address = address;
	}
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employye [Empno=" + Empno + ", Empname=" + Empname
				+ ", address=" + address + "]";
	}
	
	
}

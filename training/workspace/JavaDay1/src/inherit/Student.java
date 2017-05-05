package inherit;

public class Student extends Person {
		private int studID;
		private int std;
		
		public Student(String name, String address)
		{
			super(name, address);
		}
		
		public int getStudID() {
			return studID;
		}
		public void setStudID(int studID) {
			this.studID = studID;
		}
		public int getStd() {
			return std;
		}
		public void setStd(int std) {
			this.std = std;
		}
		
}

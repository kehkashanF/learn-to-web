
public class Rectangle {
		private double length;
		private double breadth;
		private double area;
		
		public Rectangle() {
			length=0.0;
			breadth=0.0;
		}
		
		public Rectangle(double length, double breadth){
			this.length=length;
			this.breadth=breadth;
		}
		
		public double getLength() {
			return length;
		}
		public void setLength(double length) {
			this.length = length;
		}
		public double getBreadth() {
			return breadth;
		}
		public void setBreadth(double breadth) {
			this.breadth = breadth;
		}
		
		public void areaC()
		{
			area=length*breadth; 
			
		}
		
		public void display(){
			System.out.println("Length: "+length);
			System.out.println("Breadth: "+breadth);
			System.out.println("Area: "+area);
		}
		
		
		
}

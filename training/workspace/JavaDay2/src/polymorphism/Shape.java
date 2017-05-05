package polymorphism;

public abstract class Shape {
	double area;
	
	public abstract void calcArea(double b, double l);

	public void display(){
		System.out.println("Area is: "+area);
	}
}


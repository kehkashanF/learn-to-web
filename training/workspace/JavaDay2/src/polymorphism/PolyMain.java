package polymorphism;

public class PolyMain {
	public static void main(String[] args) {
		//upcasting
		Shape p;
		//p=new Shape(); now abstract hence cannot make an object
		//p.calcArea(12.34, 16.22);
		//p.display();
		
		p=new Rectangle(); 
		p.calcArea(12.34, 16.22);
		p.display();
		//at compile time compiler checks if calcArea is available in polygon class
		//similarly for display func
		//objects are created at run time hence functions are initialized using that Object (in this case Rectangle)
		
		p=new Triangle();
		p.calcArea(12.34, 16.22);
		p.display();
		
	}
}

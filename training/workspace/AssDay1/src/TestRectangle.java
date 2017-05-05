
public class TestRectangle {
	public static void main(String[] args) {
		Rectangle r1=new Rectangle(20.0,10.0);
		r1.areaC();
		r1.display();
		Rectangle r2=new Rectangle();
		r2.setBreadth(20.0);
		r2.setLength(100.0);
		r2.areaC();
		r2.display();
	}
}

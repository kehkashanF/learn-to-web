
public class IntClass implements Int1, Int2{
	@Override
	public void m1(){
		Int1.super.m1();
		Int2.super.m1();
		
	}
	
	public static void main(String[] args) {
			new IntClass().m1();
		}
}

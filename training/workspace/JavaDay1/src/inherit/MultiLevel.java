package inherit;

import java.io.FileInputStream;

class A{
	public A() {
		System.out.println("a");
	}
}

class B extends A{
	public B() {
		System.out.println("b");
	}
	
}

class C extends B{
	public C() {
		System.out.println("c");
	}
	
}
public class MultiLevel {
	public static void main(String[] args) {
		C c=new C();
	}
}

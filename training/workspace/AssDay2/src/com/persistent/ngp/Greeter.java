package com.persistent.ngp;

public class Greeter {
	public String name;
	
	public Greeter(String name){
		this.name=name;
		
	}
	
	public void sayHello()
	{
		System.out.println("Hello "+name);
	}
	
	public void sayGoodBye()
	{
		System.out.println("Goodbye "+name);
		
	}
}

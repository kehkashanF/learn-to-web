package polymorphism;

public class Cat implements Animal, Zoo{

	@Override
	public void eat() {
		System.out.println("Milk");
		
	}

	@Override
	public void speak() {
		System.out.println("Meow!");
		
	}

	@Override
	public void Cage() {
		System.out.println("Near the pond!");
		
	}

	@Override
	public void FoodTime() {
		System.out.println("Eats at 3pm");
		
	}
	
	
	
}

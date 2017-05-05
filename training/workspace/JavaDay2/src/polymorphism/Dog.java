package polymorphism;

public class Dog  implements Animal, Zoo{

	@Override
	public void eat() {
		System.out.println("Bone");
	}

	@Override
	public void speak() {
		System.out.println("Bark!");
		
	}

	@Override
	public void Cage() {
		System.out.println("A Big Kennel!");
		
	}

	@Override
	public void FoodTime() {
		System.out.println("All Day");
		
	}
	
	

}

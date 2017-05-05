package polymorphism;

public class AnimalMain {
			public static void main(String[] args) {
				Animal animal; //reference of interface
				Zoo zoo;
				zoo=new Cat();
				animal=new Cat();
				animal.eat();
				animal.speak();
				zoo.Cage();
				zoo.FoodTime();
				
				
				
				System.out.println();
				zoo=new Dog();
				animal=new Dog();
				animal.eat();
				animal.speak();
				zoo.Cage();
				zoo.FoodTime();
			}
}

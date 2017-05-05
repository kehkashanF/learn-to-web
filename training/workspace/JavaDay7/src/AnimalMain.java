
public class AnimalMain {
		public static void main(String[] args) {
			Animal a;
			 a=new Cat();
			 a.eat();
			 a.speak();
			 a.legs("CAT");
			 
			 a=new Dog();
			 a.eat();
			 a.speak();
			 a.legs("DOG");
			 
			 a=new Bird();
			 a.eat();
			 a.speak();
			 a.legs("BIRD");
		}
}

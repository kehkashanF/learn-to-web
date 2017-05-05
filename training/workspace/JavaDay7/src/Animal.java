
public interface Animal {
		public void speak();
		public void eat();
		public default void legs(String name){
			System.out.println(name+ " has 4 legs");
		}
}


public class Bird implements Animal{

	@Override
	public void speak() {
		System.out.println("CHIRP");
	}

	@Override
	public void eat() {
		System.out.println("GRAINS");
	}

	@Override
	public void legs(String name) {
		System.out.println(name+" has 2 legs");
	}
	
	

}

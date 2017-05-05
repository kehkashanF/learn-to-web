
public class LamdaExpGreet {
		public static void main(String[] args) {
			
			//Greeting Interface
			//w/o parenthesis
			Greeting greet1 = name->{
											System.out.println("Hello "+name);
											System.out.println("Go Home");
									};
									
			// with parenthesis						
			Greeting greet2 = (String name) -> System.out.println("Parenthesis hello "+name);
			
			greet1.greet("YO YO U2");
			greet2.greet("BONO");
			
			//Animal Interface (it was a functional interface)
			//when no parameters, empty parenthesis are reqd
//			Animal cat = () -> System.out.println("MEOW");
//			Animal dog = () -> System.out.println("BARK");
//			Animal hen = ()-> System.out.println("CLUCK");
//			
//			cat.speak();
//			dog.speak();
//			hen.speak();
//			
			//Operations Interface
			//when return type present
			Operations add = (int a, int b)-> a+b;
			Operations subtract=(a,b)-> a-b;
			
			//to specify return statement we must USE {} and end with ;
			Operations multiple = (a,b)->{return a*b;};
			
			Operations divide = (a,b)->a/b;
			
			System.out.println("Adding: "+add.operations(20,20));
			System.out.println("Subtracting : "+subtract.operations(30, 90));
			System.out.println("Multiplying: "+multiple.operations(30, 6));
			System.out.println("Dividing: "+divide.operations(30, 6));
			
		}
}

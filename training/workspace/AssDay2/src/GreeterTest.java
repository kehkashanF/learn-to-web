import com.persistent.ngp.*;
public class GreeterTest {
		public static void main(String[] args) {
			Greeter g=new Greeter(args[0]);
			Greeter g2=new Greeter(args[1]);
			Advisor ad=new Advisor();
			g.sayHello();
			g2.sayHello();
			ad.getAdvice();
			System.out.println(ad.getAdvice());
			g2.sayGoodBye();
			g.sayGoodBye();
			
		}
}

package multithreading;


public class Prog4 {
		public static void main(String[] args) {
				FileC fc=new FileC();
				new ReadThread(fc);
				new FactorialThread(fc);

		}
}

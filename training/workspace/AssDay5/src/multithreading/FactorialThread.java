package multithreading;

public class FactorialThread extends Thread{
	FileC fc;	
	
	public FactorialThread(FileC fc) {
			this.fc=fc;
			start();
	}
	
	@Override
	public void run() {
		int fact1;
		int i=5;
		while(i>0){
			System.out.println("Factorial: "+fc.calcFact());
			i--;
		}
	}
		
}

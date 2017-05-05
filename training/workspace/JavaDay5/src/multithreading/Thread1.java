package multithreading;

public class Thread1 extends Thread {

	@Override
	public void run() {
//		3. Running state - run method is getting executed <-----(!)
		System.out.println("inside Run");						
	}
//	4. Dead state - execution is complete
	public static void main(String[] args) {
		//1. New born state - creating thread object
		Thread t1 = new Thread1();
		
		//2. Ready/runnable state - ready to execute
		t1.start(); //pushing thread on thread pool
		
		//processor controls when run() is called ----------- (!)
	}
	
		
}

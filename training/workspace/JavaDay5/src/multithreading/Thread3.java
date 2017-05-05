package multithreading;

public class Thread3 implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside run");
		
	}
		
	public static void main(String[] args) {
		
		Thread3 t = new Thread3();	//knows run()
		    //knows start()
		Thread t1=new Thread(t);
		t1.start();
	}
}

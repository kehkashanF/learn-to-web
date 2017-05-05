package multithreading;

public class Thread2 extends Thread{

	public Thread2(String name) {
		super(name);
		start();
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(getName()+" : "+i);
//			System.out.println("Child Thread: "+i);

		//5. Paused State - in milliseconds
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void main(String[] args) {
		
		Thread2 t1 = new Thread2("ONE");

		Thread2 t2 = new Thread2("TWO");

		Thread2 t3 = new Thread2("THREE");

		Thread2 t4 = new Thread2("FOUR");
		t1.setPriority(4);
		t2.setPriority(9);
		t3.setPriority(1);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
	}
		
	
	
}

package multithreading;

public class Resource {
			public synchronized void PrintMsg(String msg){
				System.out.print("[ "+msg+ " ");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("] ");
			}
}

package multithreading;


public class FileC {
	private int x;
	public boolean flag=true;
	
	
	public synchronized void readInteger(int x){
			if(flag==false){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			flag=false;
			this.x=x;
			System.out.println("X: "+this.x);
			notify();

	}
	
	public synchronized int calcFact(){
		if(flag==true){
			try {
				wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			
		}
		flag=true;
		int fact=1;
		System.out.println(this.x);	
		while(x>0)
		{
			fact=fact*x;
			x--;
		}
		notify();
		return fact;
	}
}

package multithreading;

public class Test {
		private int num;
		private boolean flag=true;
		
		public synchronized void setNum(int num) {
			if(flag==false){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			flag=false;
			this.num = num;
			System.out.println("SET: "+num);
			notify();
		}
		
		public synchronized int getNum() {
			if(flag==true){
				try {
					wait();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				
			}
			flag=true;
			System.out.println("GOT: "+num);
			notify();
			return num;
			
		}
}

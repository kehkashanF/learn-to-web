package multithreading;

public class ConsumerThread extends Thread{
			Test test;
			
			public ConsumerThread(Test test) {
				this.test=test;
				start();
			}
			
			@Override
			public void run() {
				int x;
				int i=0;
				while(i<10){
					x=test.getNum();
					i++;
				}
			}
}

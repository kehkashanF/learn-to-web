package multithreading;

public class ProducerThread extends Thread{
			Test test;
			public ProducerThread(Test test) {
						this.test=test;
						start();
			}
			
			@Override
			public void run() {
				int x=0;
				while(x<10)
					test.setNum(x++);
			}
}

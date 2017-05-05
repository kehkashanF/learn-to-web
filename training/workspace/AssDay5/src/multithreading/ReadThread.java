package multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadThread extends Thread {
		FileC fc;
		
		public ReadThread(FileC fc) {
			this.fc=fc;
			start();
		}
		@Override
		public void run() {
			int x;
			try {
				Scanner s = new Scanner(new FileInputStream("Integer"));
				
				while(s.hasNextLine()){
					x=Integer.parseInt(s.nextLine());
					fc.readInteger(x);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
}

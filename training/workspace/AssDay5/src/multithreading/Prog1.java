package multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Prog1 extends Thread{
		String search;
		
		public Prog1(String search) {
				this.search=search;
				start();
		}
	
		@Override
		public void run() {
					Scanner s=null;
					try {
						s = new Scanner(new FileInputStream("Threading"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				boolean flag=false;
					String test;
					
					while(s.hasNextLine()){
						test=s.nextLine();
						if(test.contains(search)){
							System.out.println("String: " +search+ " is found!");
							flag=true;
							
					}
						
					}
					
					if(!flag)
					{
						System.out.println("Could not find line: " +search);
					}

		}
	
		public static void main(String[] args) {
				Prog1 p1=new Prog1(args[0]);
				Prog1 p2=new Prog1(args[1]);
				Prog1 p3=new Prog1(args[2]);
				Prog1 p4=new Prog1(args[3]);
				
//				p1.start();
//				p2.start();
//				p3.start();
//				p4.start();
				
			
		}
}

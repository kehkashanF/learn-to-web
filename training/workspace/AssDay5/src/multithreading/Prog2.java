package multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog2 extends Thread {
	private String file;
	public Prog2(String file) {
		this.file=file;
		start();
	}
	
	@Override
	public  void run() {
		
		try {
			Scanner s=new Scanner(new FileInputStream(file));
			while(s.hasNextLine()){
				System.out.println(file+" : "+s.nextLine());
				Thread.sleep(2000);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Prog2 p1=new Prog2(args[0]);
		Prog2 p2=new Prog2(args[1]);
		
	}
}

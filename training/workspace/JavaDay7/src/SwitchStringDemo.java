import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SwitchStringDemo {
	
	
		private static void printFile(){
			//try with resources - AutoClosableInterface - causes auto close() invocation
			try(FileInputStream in=new FileInputStream("file.txt");
					BufferedInputStream br=new BufferedInputStream(in)){
				
				int data;
				while((data=br.read())!=-1)
					System.out.println((char)data);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			String food;
			int carCost = 48_87_653;
			float busCost=16_47_812.2_567f;
			Scanner s=new Scanner(System.in);
			
			food=s.nextLine();
			switch(food){
			case "veg":
			case "VEG":
			case "Veg":
				System.out.println("Cow goes MOOOOOO");
				break;
			case "Non Veg":
				System.out.println("Tiger goes ROAAAAAAAAARRRR");
				break;
				
			}
			
			System.out.println("Car Cost: "+carCost);
			System.out.println("Bus Cost: "+busCost);
			
//	compiler error
			//String nums="12_34_456";
//			int num=Integer.parseInt(nums);
			int b=10, x[]={10,20,30};
			
			//multiple exceptions single catch block
			try{
				int c=x[0]/b;
				System.out.println(c);
				String str="Hello";
				System.out.println(str.charAt(15));
			}catch(ArithmeticException | ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e){
				System.out.println(e);
			}
			
			//try block with resources
			printFile();
			
			
			//automatic mapping by diamond operator
			
			List<String> list=new ArrayList<>();
			
			list.add("abc");
			list.add("123");
			//error: list.add(123);
			
		}
}

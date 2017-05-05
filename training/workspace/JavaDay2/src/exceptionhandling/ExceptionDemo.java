package exceptionhandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionDemo {
	public static void main(String[] args) {
		int a, b, c;
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter values for a & b: ");
			a=Integer.parseInt(br.readLine());
			b=Integer.parseInt(br.readLine());
			c=a/b;
		
		System.out.println("c is: "+c);
		
		String str="Hello";
		char d=str.charAt(10);
		}
		catch(ArithmeticException e)
		{
			System.out.println("b cannot be 0");
			a=0;
			
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("String is too long");
		}
		catch(Exception e){
			System.out.println("Please check input!");
			
		}
		finally{
			System.out.println("Final Block");
			
		}
	}
}

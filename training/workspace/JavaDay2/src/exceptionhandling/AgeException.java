package exceptionhandling;

public class AgeException extends Exception{
	public AgeException(String msg) {
		System.out.println(msg);
	}
}

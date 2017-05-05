
public class prob1 {
	public static void main(String[] args) {
		int length;
		 length=args[0].length();
		 String s=args[0];
		 System.out.println("String is: "+args[0]);
		 System.out.println("In Upper Case:"+s.toUpperCase());
		 System.out.println("Length of string is "+length);
		 System.out.println("Checking for palindrome...");
		
		StringBuffer buf=new StringBuffer(s);
		buf.reverse();
		String rev=buf.toString();
		if(rev.equalsIgnoreCase(s))
		{
			System.out.println("Palindrome");
			
		}
		else
			System.out.println("Not Palindrome");
	}
}

import java.util.*;
public class FindNumber {
	static int findPosition(int num,int[] nos)
	{
		for(int i=0;i<nos.length;i++)
		{
			if(num==nos[i])
			{
				return i;
			}
			
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int nos[]=new int[10];
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 10 integers: ");
		for(int i=0;i<10;i++)
			nos[i]=s.nextInt();
		System.out.println("Enter number to search in array: ");
		int num=s.nextInt();
		
		int pos;
		pos=findPosition(num,nos);
		
		if(pos==-1)
			System.out.println("Number not found!");
		else
			System.out.println("Number " + num + "is at position " + pos);
	}		
}

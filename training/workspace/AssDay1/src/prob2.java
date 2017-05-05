
public class prob2 {
	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		System.out.println("Your first number was: "+a);
		System.out.println("Your second number was: "+b);
		int arr[]=new int[5];
		boolean flaga=false;
		boolean flagb=false;
		int t=a;
		System.out.print(a+" "+b);
		for(int i=0;i<13;i++)
		{
			t=t+b;
			System.out.print(t+" ");
			b=t;
		
		}
		for(int i=0;i<5;i++)
		{	
			arr[i]=(int)(Math.random()*100)%40;
			System.out.println(arr[i]);
			
		}
		
		for(int i=0;i<5;i++)
		{
			
			if(a==arr[i])
			{
				flaga=true;
				break;
			}
		}
		for(int i=0;i<5;i++)
		{
			
			if(b==arr[i])
			{
				flagb=true;
				break;
			}
		}
			
		if(flaga&&flagb)
		{
			System.out.println("BINGO");
		}
		else
			System.out.println("No Luck!");
	}
}

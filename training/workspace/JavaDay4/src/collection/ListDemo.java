package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			list.add((int)(Math.random()*100%10)+1);
		}
		System.out.println("Size: "+ list.size()+" - "+ list);
		boolean isAvailable=list.contains(9);
		if(isAvailable)
			System.out.println("Element Found!");
		else
			System.out.println("Not Found!");
		list.remove(6);
		System.out.println("Size: "+ list.size()+" - "+ list);
		
	}
	
	
	
}

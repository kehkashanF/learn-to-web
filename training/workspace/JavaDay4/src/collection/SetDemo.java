package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		
		//uses equals() and hashcode() to return hash value
		//if equals() does not return -1 to hashcode() that means that same element is already present and value is rejected, 
		//else accepted and hascode() creates 
				Set<Integer> set=new HashSet<Integer>(); //random storage based on hashcode()
				set.add(60);
				set.add(70);
				set.add(10);
				set.add(90);
				set.add(40);
				set.add(30);
				System.out.println("Hash Set: "+set);
				Iterator<Integer> itr=set.iterator();
				System.out.println(itr.getClass().getName());
				int total=0;
				while(itr.hasNext())
				{
					total+=itr.next(); //auto unboxing
				}
				System.out.println("Total: "+total);
				/*set=new LinkedHashSet<Integer>(); //follows insertion order
				
				set.add(60);
				set.add(70);
				set.add(10);
				set.add(90);
				set.add(40);
				set.add(30);
				System.out.println("Linked Set: "+set);
				
				set=new TreeSet<Integer>(); //orders the input
				
				set.add(60);
				set.add(70);
				set.add(10);
				set.add(90);
				set.add(40);
				set.add(30);
				System.out.println("Tree Set: "+set);
				
				/*o/p: Hash Set: [70, 40, 10, 30, 90, 60]
					Linked Set: [60, 70, 10, 90, 40, 30]
						Tree Set: [10, 30, 40, 60, 70, 90]*/
	}
}

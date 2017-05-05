import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;


public class NavigableSetDemo {
		public static void main(String[] args) {
			NavigableSet<Integer> ns=new TreeSet<Integer>();
			
			ns.add(20);
			ns.add(30);
			ns.add(40);
			ns.add(60);
			ns.add(80);
			ns.add(50);
			ns.add(70);
			System.out.println("***********Using for each********");
			for(Integer i:ns)
			{
				System.out.println(i);
			}
			System.out.println("**********Using Iterator**********");
			Iterator<Integer> itr=ns.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
			System.out.println("**********Using Descending Iterator**********");
			
			Iterator<Integer> ditr=ns.descendingIterator();
			while(ditr.hasNext())
				System.out.println(ditr.next());
			System.out.println("**************************************************");
			//lower() returns greatest elements less than given element; null if no such element
				Integer lval=ns.lower(60);
			System.out.println("Greatest less than 60: "+lval);
			
			//higher returns smallest element greater than given element; else null
			Integer hval=ns.higher(60);
			System.out.println("Least greater than 60: "+hval);
			
			//pollfirst()-removes lowest
			System.out.println("Lowest: "+ns.pollFirst());
			//pollLast()-removes highest
			System.out.println("Highest: "+ns.pollLast());
			
			
			//ceiling()-smallest element greater than OR EQUAL to given element
			//floor()-greatest element greater than OR EQUAL to given element
			System.out.println("Least greater than or equal to 60: "+ns.ceiling(60));
			System.out.println("Greatest less than or equal to 60: "+ns.floor(60));
			
//			All elements less than 50: [30, 40]
//					All elements less than or equal to 50: [30, 40, 50]
			SortedSet<Integer> ss=ns.headSet(50);
			System.out.println("All elements less than 50: "+ss);
			NavigableSet<Integer> nset=ns.headSet(50, true);
			System.out.println("All elements less than or equal to 50: "+nset);
			
//			
//			All elements greater than 50: [50, 60, 70]
//			All elements greater than or equal to 50: [60, 70]
			SortedSet<Integer> ss1=ns.tailSet(50);
			System.out.println("All elements greater than 50: "+ss1);
			NavigableSet<Integer> nset1=ns.tailSet(50, false);
			System.out.println("All elements greater than or equal to 50: "+nset1);
			
			
		//subset() - returns SortedSet: subset of values (option to include or exclude fence elements) between two fence elements
			System.out.println(ns);
			SortedSet<Integer> set1=ns.subSet(30, true, 70, true);
			System.out.println(set1);
			
			
			SortedSet<Integer> set2=ns.subSet(30, false, 70, false);
			System.out.println(set2);
			
			SortedSet<Integer> set3=ns.subSet(30, 70);
			System.out.println(set3);
		}
}

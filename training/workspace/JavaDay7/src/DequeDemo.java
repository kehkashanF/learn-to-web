import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;


public class DequeDemo {
		public static void main(String[] args) {
			Deque<Integer> dq=new ArrayDeque<Integer>();
			dq.add(20);
			dq.add(30);
			dq.add(40);
			
			
			dq.addFirst(50);
			dq.addLast(70);
			
			Iterator<Integer> itr=dq.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
			System.out.println("--------------------------");
			
			Iterator<Integer> ditr=dq.descendingIterator();
			while(ditr.hasNext())
				System.out.println(ditr.next());
		}
}

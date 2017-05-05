import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class PersonMain {
		public static void main(String[] args) {
			
			Comparator<Person> compName=(Person p1, Person p2) -> p1.getName().compareToIgnoreCase(p2.getName()); 
			
			Comparator<Person> compAge=(Person p1, Person p2) -> (p1.getAge()<p2.getAge())?-1:(p1.getAge()>p2.getAge())?1:0;
														
			
			List<Person> list=new ArrayList<Person>();
			list.add(new Person(50, "Pappa"));
			list.add(new Person(1, "Rozie"));
			list.add(new Person(20,"Bushy"));
			list.add(new Person(45, "Mumma"));
			
			System.out.println(list);
			System.out.println("**************After Sorting List by Name using Lamda**************");
			Collections.sort(list, compName);
			System.out.println(list);
			
			list.add(new Person(50, "Pappa"));
			list.add(new Person(1, "Rozie"));
			list.add(new Person(20,"Bushy"));
			list.add(new Person(45, "Mumma"));
			
			Person p=new Person();
			Collections.sort(list, p::comparebyName);
			Collections.sort(list, Person::sortbyName);
			Set<Person> set=new TreeSet<Person>(compAge);
			
			set.add(new Person(20,"Bushy"));
			set.add(new Person(1, "Rozie"));
			set.add(new Person(50, "Pappa"));
			set.add(new Person(45, "Mumma"));
			System.out.println("****************Sorted by Age Set*****************");
			System.out.println(set);
			
			System.out.println(compName.getClass().getName());
			
			
		}
}

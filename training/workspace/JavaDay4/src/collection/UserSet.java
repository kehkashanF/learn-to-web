package collection;

import java.util.TreeSet;
import java.util.Set;

public class UserSet {
	public static void main(String[] args) {
			Set<User> set=new TreeSet<User>(new UserNameComparator());
			set.add(new User("Ramlal","ram123"));
			set.add(new User("Suresh", "Ramesh"));
			set.add(new User("Pyaare", "Mohan"));
			
			System.out.println(set);
	}
}

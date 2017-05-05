package collection;

import java.util.Comparator;

public class UserNameComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		String uname1=o1.getUname();
		String uname2=o2.getUname();
				
		return uname1.compareTo(uname2);
	}
	
}

import java.util.NavigableMap;
import java.util.TreeMap;


public class NavigableMapDemo {
			public static void main(String[] args) {
				NavigableMap<Integer, String> nm=new TreeMap<Integer, String>();
				
				nm.put(1, "dggd");
				nm.put(2, "hghj");
				nm.put(3,"ghjhsd");
				nm.put(5, "jsdhyjkh");
				nm.put(4, "hjsda");
				
				System.out.println(nm);
				
			}
}

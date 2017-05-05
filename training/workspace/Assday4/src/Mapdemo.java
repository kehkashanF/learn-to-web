import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Mapdemo {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		int key;
		String value;
		Scanner s= new Scanner(System.in);
		for(int i=0;i<5;i++){
		System.out.println("Enter the key and value: ");
		key=Integer.parseInt(s.nextLine());
		value=s.nextLine();
		
		map.put(key, value);
		}
		
		System.out.println(map);
		
		Set<Integer> keys=map.keySet();
		for(Integer key1: keys){
			String value1=map.get(key1);
			System.out.println(key1 + " : "+ value1);
		}
		
		Collection<String> val=map.values();
		for(String s1: val)
			System.out.println(s1);
		
		boolean keyThere=map.containsKey(123);
		if(keyThere)
			System.out.println("There");
		else
			System.out.println("Not There");
		
		boolean valThere=map.containsValue("kehkashan");
		
		
		
	}
}

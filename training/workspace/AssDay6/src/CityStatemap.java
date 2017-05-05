import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class CityStatemap {
		public static void main(String[] args) {
			Map<String, String> cs=new HashMap<String, String>();
			String city;
			String state;
			Scanner s1=new Scanner(System.in);
			try {
				Scanner s=new Scanner(new FileInputStream("CityState"));
				while(s.hasNextLine())
				{
					String[] token=s.nextLine().split(":");
					city=token[0];
					state=token[1];
					
					cs.put(city, state);
					
				}
				
				System.out.println(cs);
				System.out.println("Printing all cities: ");
				Set<String> cities=cs.keySet();
				System.out.println(cities);
				
				Collection<String> states=cs.values();
				System.out.println("All States in file: ");
				System.out.println(states);
				Set<String> cities1=new HashSet<String>();
				System.out.println("Enter state to get cities within it: ");
				
				String state1=s1.nextLine();
				for(Map.Entry<String, String> entry:cs.entrySet()){
					if(state1.equals(entry.getValue()))
							cities1.add(entry.getKey());
				}
				System.out.println(cities1);
				//System.out.println("Enter city value to get its state: ");
				
				System.out.println("Enter state to delete cities within it: ");
				state1=s1.nextLine();
				
				Set<String> del=new HashSet<String>();
				for(Map.Entry<String, String> entry1: cs.entrySet()){
					if(state1.equals(entry1.getValue())){
						String key=entry1.getKey();
						//cs.remove(key);
						del.add(key);
					}
				}
				
				for(String k1: del){
					cs.remove(k1);
				}
				System.out.println("New Map: "+cs);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}
			
			
		}
}

import java.util.ArrayList;


public class ArrayLDemo {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList();
		al.add("ahsjdh");
		al.add("gutter");
		al.add("jdgf");
		al.add("shdghjgdf");
		al.add(3, "Four");
		for(String s:al)
		{
			System.out.println(s);
		}
		System.out.println(al.size());
		System.out.println(al.get(4));
		
	}
}

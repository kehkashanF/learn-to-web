import java.util.*;
public class toReverse {
	static String  makeReverse(String str){
		String[] rev=str.split(" ");
		int i=0;
		for(String str1:rev)
		{
			StringBuffer s=new StringBuffer(str1);
			s.reverse();
			str1=s.toString();
			rev[i]=str1;
			i++;
		}
		StringBuilder reverse=new StringBuilder();
		for(String str2:rev)
			reverse.append(str2+" ");
		String rev2=
		reverse.toString();
		return rev2;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str;
		System.out.println("Enter string: ");
		str=s.nextLine();
		String rev=makeReverse(str);
		System.out.println(rev);
	}

}

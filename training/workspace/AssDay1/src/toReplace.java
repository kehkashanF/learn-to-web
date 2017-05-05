import java.io.*;
public class toReplace {
	static String letsReplace(String str, String sub, String rep)
	{
		String rap;
		rap=str.replace(sub, rep);
		
		return rap;
		
	}
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		String sub=null;
		String rep=null;
		try {
			
			System.out.println("Enter string, substring and its replacement: ");
			str=br.readLine();
			sub=br.readLine();
			rep=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(letsReplace(str,sub,rep));
	}
}

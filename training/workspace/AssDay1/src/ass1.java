
public class ass1 {
	static int check(String sentence, String word){
		int count=0;
		String words[]=sentence.split(" ");
		for(String string:words)
		{
			if(string.equalsIgnoreCase(word))
				count++;
			
		}
		return count;
		
		
	}
	
	public static void main(String[] args) {
		System.out.print("Number of occurrences: "+check("is is is is si si is has si is", "is"));
	}
}

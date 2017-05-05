import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentArray {
	public static void main(String[] args) {
		List<String> student=new ArrayList<String>();
		Scanner s=new Scanner(System.in);
		String str=null;
		boolean flag=true;
		for(int i=0;i<3;i++){
		System.out.println("Enter name: ");
		str=s.nextLine();
		student.add(str);
		}
		System.out.println("Students: "+student);
		System.out.println("Enter name you want to search: ");
		str=s.nextLine();
		if(student.contains(str))
			System.out.println("Student in database.");
		else
				System.out.println("No such student found.");
	}	
	

		
}

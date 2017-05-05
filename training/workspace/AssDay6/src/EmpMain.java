import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class EmpMain {
		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			Set<Emp> set=new TreeSet<Emp>(new EmpComparator());
			for(int i=0;i<4;i++){
				System.out.println("Enter id: ");
				int id=Integer.parseInt(s.nextLine());
				System.out.println("Enter name: ");
				String name=s.nextLine();
				System.out.println("Enter Job");
				String job=s.nextLine();
				System.out.println("Enter date: ");
				String strDate=s.nextLine();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					date = sdf.parse(strDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				set.add(new Emp(id,name,job,date));
			}
			
			System.out.println(set);
			
			
		}
}

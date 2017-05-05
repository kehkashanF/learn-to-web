
public class StudentMain {
	static{
		
		System.out.println("Inside static");
	}
	static{
		System.out.println("Inside 2");
	}
	static{
		System.out.println("Inside 3");
	}
	{
		System.out.println("Instance");
	}
	public StudentMain()
	{
		System.out.println("Constructor");
	}
	
	
	public static void main(String[] args) {
			System.out.println("Inside Main");
			new StudentMain();
			student stud=new student("Ram", 4);
			stud.printStudent();
			student stud1=new student("Sita", 5);
			stud1.printStudent();
			student stud2=new student("Gita", 6);
			stud2.displayStudent(stud2);
		}
}

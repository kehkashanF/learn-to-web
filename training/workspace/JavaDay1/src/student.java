
public class student {
	private static int rollNo;
	private String name;
	private int std;
	
	public student(String name, int std) {
		rollNo++;
		this.name=name;
		this.std=std;
	}
	
	public void printStudent(){
		System.out.println("Roll No.: "+rollNo);
		System.out.println("Name:"+name);
		System.out.println("Std:"+std);
	}
	
	public static void displayStudent(student s){
		//System.out.println("Roll No.: "+rollNo);
		//err:System.out.println("Name:"+name);
		//err:System.out.println("Std:"+std);
		//cannot access non-static data members directly
		//create object to access non-static data member
		s.printStudent();
	}
}

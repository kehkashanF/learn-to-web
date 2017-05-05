import java.util.Scanner;


public class EmpMain {
	

	public static void main(String[] args) {
		EmpFunc ef=new EmpFunc();
		Employee emp = new Employee();
		Scanner s=new Scanner(System.in);
		int id;
		String name;
		int did;
		String job;
		System.out.println("Enter your choice: ");
		int ch;
		int choice;
		do{
			System.out.println("Menu: ");
			System.out.println("1. Add Employee Details");
			System.out.println("2. Update Employee Details");
			System.out.println("3. Search Employee by ID");
			System.out.println("4. Delete Employee");
			System.out.println("5. Add, Update and Delete");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			
			choice=Integer.parseInt(s.nextLine());
			
			switch(choice){
			case 1:
				System.out.println("Enter Employee Details: ");
				System.out.print("ID: ");
				id=Integer.parseInt(s.nextLine());
				emp.setId(id);
				System.out.print("Name: ");
				name=s.nextLine();
				emp.setName(name);
				System.out.println("Dept Id: ");
				did=Integer.parseInt(s.nextLine());
				emp.setDeptId(did);
				System.out.println("Job: ");
				job=s.nextLine();
				emp.setJob(job);
				
				ef.addEmp(emp);
				break;
				
			case 2:
				System.out.println("Enter Employee ID:");
				id=Integer.parseInt(s.nextLine());
				emp.setId(id);
				System.out.println("Enter new Name: ");
				name=s.nextLine();
				emp.setName(name);
				System.out.println("Enter new Job: ");
				job=s.nextLine();
				emp.setJob(job);
				
				ef.UpdateEmployee(emp);
				break;
				
			case 3:
				int id1;
				System.out.println("Enter ID of employee to be searched: ");
				id1=Integer.parseInt(s.nextLine());
				
				ef.searchEmployee(id1);
				break;
				
			case 4:
				int id11;
				System.out.println("Enter ID of employee to be deleted: ");
				id11=Integer.parseInt(s.nextLine());
				
				ef.deleteEmployee(id11);
				break;
				
			//case 5:
				
				
				
				//break;
				
			case 6: 
				break;
		
			default:
				System.out.println("Please enter correct choice...");
				break;
				
			}
			
			System.out.println("Do you wish to continue? (0/1)");
			ch=Integer.parseInt(s.nextLine());
		}while(ch==1);
	}
}

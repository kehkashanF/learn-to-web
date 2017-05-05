
public class PersonTest {
	public static void main(String[] args)
	{
		//create object of Person class
		//Class_name Obj_name = new Class_name();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3=new Person("Owais", 3);
		//access instance data members
		//obj_name.variable_name;
		person1.setName("Kehkashan");
		person1.setAge(22);
		System.out.println("Name: "+person1.getName());
		System.out.println("Age:"+person1.getAge());
		
		System.out.println("Name: "+person2.getName());
		System.out.println("Age:"+person2.getAge());
		
		System.out.println("Name: "+person3.getName());
		System.out.println("Age:"+person3.getAge());
		
	}
	
}

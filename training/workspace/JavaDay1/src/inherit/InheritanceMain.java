package inherit;

public class InheritanceMain {
	public static void main(String[] args) {
		Person p=new Person("Rozina","Mahdi Bagh");
		//p.setName("Rozina");
		//p.setAddress("Mahdi Bagh");
		
		
		Employee e=new Employee("Owais","Wadi",123,"Dukaandaar");
		//e.setName("Owais");
		//e.setAddress("Wadi");
		//e.setEmpId(123);
		//e.setDesignation("Dukaandaar");
		
		Student s=new Student("Meher","West Lafayette");
		//s.setName("Meher");
		//s.setAddress( "West Lafayette");
		s.setStudID(456);
		s.setStd(1);
	}
}

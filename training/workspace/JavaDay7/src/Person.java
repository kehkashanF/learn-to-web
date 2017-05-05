
public class Person {
			private int age;
			private String name;
			
			public Person() {
				// TODO Auto-generated constructor stub
			}
			public Person(int age, String name) {
				super();
				this.age = age;
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			@Override
			public String toString() {
				return "Person [age=" + age + ", name=" + name + "]";
			}
			
			public static int sortByAge(Person p1, Person p2){
				return (p1.getAge()<p2.getAge())?-1:(p1.getAge()>p2.getAge())?1:0;
			}
			
			public int compareByAge(Person p1, Person p2){
				return (p1.getAge()<p2.getAge())?-1:(p1.getAge()>p2.getAge())?1:0;
			}
			
			public static int sortbyName(Person p1, Person p2){
				return p1.getName().compareToIgnoreCase(p2.getName());
			}
			
			public int comparebyName(Person p1, Person p2){
				return p1.getName().compareToIgnoreCase(p2.getName());
			}
}

package exceptionhandling;

public class User {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) //throws AgeException
	{
		if(age < 18)
			try {
				throw new AgeException("Age cannot be <18");
			} catch (AgeException e) {
				e.printStackTrace();
			}
		else
			this.age = age;
	}
	
	public static void main(String[] args) {
		User u=new User();
		//try {
			u.setAge(12);
		//} catch (AgeException e) {
			//e.printStackTrace();
		//}
	}
}

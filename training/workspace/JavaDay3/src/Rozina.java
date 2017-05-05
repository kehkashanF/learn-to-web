import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Rozina implements Serializable{
		private String name;
		private int age;
		private String address;
		
		public Rozina(String name, int age, String address) {
			this.name=name;
			this.age=age;
			this.address=address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		public void display()
		{
			System.out.println("Name: "+name);
			System.out.println("Age: "+age);
			System.out.println("Address: "+address);
			System.out.println("Is my baby :)");
		}
		
		
		public static void main(String[] args) {
			Rozina rosie= new Rozina("Rosie",1,"Mahdi Bagh");
			ObjectOutputStream os=null;
			
			try {
				os=new ObjectOutputStream(new FileOutputStream("object1"));
				os.writeObject(rosie);
				System.out.println("Object written!");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(os!=null)
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}
			
			rosie=null;
			ObjectInputStream ois=null;
			 try {
				ois=new ObjectInputStream(new FileInputStream("object1"));
				Rozina rose=(Rozina)ois.readObject();
				rose.display();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally{
				if(ois!=null)
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}
			 
			
		}
}

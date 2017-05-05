import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectIO {
			public static void main(String[] args) {
				String str="Welcome to Persistent!";
				ObjectOutputStream os=null;
				try {
					os=new ObjectOutputStream(new FileOutputStream("object"));
					os.writeObject(str);
					System.out.println("Object written!");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(os!=null)
						try {
							os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				
				ObjectInputStream ois=null;
				try {
					ois=new ObjectInputStream(new FileInputStream("object"));
					String str1=(String) ois.readObject();
					System.out.println(str1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(ois!=null)
						try {
							ois.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				
			}
}

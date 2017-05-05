import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataIO {
		public static void main(String[] args) {
			DataOutputStream dos=null;
			DataInputStream din=null;
			try {
				dos=new DataOutputStream(new FileOutputStream("data"));
				dos.writeInt(18);
				dos.writeFloat(18.90f);
				dos.writeBoolean(true);
				dos.writeChar('a');
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				if(dos!=null)
					try {
						dos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
			try {
				din=new DataInputStream(new FileInputStream("data"));
				int a;
				float b;
				boolean c; 
				char d;
				a=din.readInt();
				b=din.readFloat();
				c=din.readBoolean();
				d=din.readChar();
				System.out.println(a+" "+b+" "+c+" "+d);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(din!=null)
					try {
						din.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
		}
}

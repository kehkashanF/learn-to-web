import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FilereaderDemo {
		public static void main(String[] args) {
			FileReader fr=null;
			FileWriter fw=null;
			try {
				fr=new FileReader("file");
				fw=new FileWriter("file1");
				int data;
				while((data=fr.read())!=-1){
					System.out.print((char)data);
					fw.write((char)data);
				}
				
				String str=" So I freakin' READ it :P";
				fw.write(str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(fr!=null&&fw!=null)
					try {
						fr.close();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			System.out.println();
			try {
				fr=new FileReader("file1");
				int data1;
				try {
					while((data1=fr.read())!=-1)
						System.out.print((char)data1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				if(fr!=null)
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			
		}
}

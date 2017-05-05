import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIODemo {
			public static void main(String[] args) {
				//public int read() throws IOException
				FileInputStream fin=null;
				FileOutputStream fout=null;
				BufferedInputStream bis=null;
				BufferedOutputStream bos=null;
				
				try {
					fin = new FileInputStream("file");
					bis=new BufferedInputStream(fin);
					fout = new FileOutputStream("file1");
					 bos=new BufferedOutputStream(fout);
					int data;
					while((data=bis.read())!=-1){
							System.out.print((char)data);
							bos.write((byte)data);
					}
					String str="Was written in this file";
					byte[] b=str.getBytes();
					bos.write(b);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(bis!=null)
						try {
							bis.close();
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
				}
				
				System.out.println("\n");
				try {
					bis=new BufferedInputStream(new FileInputStream("file1"));
					int data;
					while((data=bis.read())!=-1)
					{
						System.out.print((char)data);
						
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(bis!=null)
						try {
							bis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				
			}
}

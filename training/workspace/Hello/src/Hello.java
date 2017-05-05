import java.sql.Connection;
import java.sql.DriverManager;


public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(" Hello World...");
		System.out.println();
	java.lang.System.out.print("sdfsdf");
	Class.forName("com.mysql.jdbc.Driver");
	Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
	System.out.println(" Cn "+cn);
	}

}

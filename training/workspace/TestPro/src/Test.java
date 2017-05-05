import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
			st=cn.createStatement();
			rs=st.executeQuery("select * from dummy");
			rs.next();
			System.out.println(" done :"+rs.getString(1));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

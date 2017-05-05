import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnect {
			public static void main(String[] args) {
				Connection con=null;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
					System.out.println("Database Connected");
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}finally{
					if(con!=null)
						try {
							con.close();
						} catch (SQLException e) {
						e.printStackTrace();
						}
				}
			}
}

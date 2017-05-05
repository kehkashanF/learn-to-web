import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StatementDemo {
	public static void main(String[] args) {
		Connection con=null;
		
		
		try {
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Connect to db
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
			System.out.println("Database Connected");
			con.setAutoCommit(false); //manual commit and rollback reqd
			
			//3. Execute Query (using Statement)
			Statement stmt=con.createStatement();
			String query="insert into products values(102,'Laptop',20)";
			int i=stmt.executeUpdate(query);
			if(i>0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			
			ResultSet rs=stmt.executeQuery("select * from products");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println("-------------------------");
			}
			con.rollback(); //rolls back the present changes
			con.commit(); //commits
			
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

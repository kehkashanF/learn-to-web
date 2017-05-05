import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmpFunc {
		
		public String url="jdbc:mysql://localhost:3306/emp";
		public String user="root";
		public String password="root";
		
		
		public void addEmp(Employee emp){
			Connection con=null;
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);
				
				PreparedStatement pst=con.prepareStatement("Insert into employee(empId, empName, deptId, job) values (?,?,?,?)");
				pst.setInt(1, emp.getId());
				pst.setString(2,emp.getName());
				pst.setInt(3, emp.getDeptId());
				pst.setString(4, emp.getJob());
				
				int i=pst.executeUpdate();
				if(i>0)
					System.out.println("Added rows");
				else
					System.out.println("Could not add");
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
		
		public void UpdateEmployee(Employee emp){
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);
				
				PreparedStatement pst=con.prepareStatement("Update employee set empName=?, job=? where empId=?");
				pst.setString(1, emp.getName());
				pst.setString(2, emp.getJob());
				pst.setInt(3, emp.getId());
				int i=pst.executeUpdate();
				if(i>0)
					System.out.println("Updated");
				else
					System.out.println("Could not update");
			}catch (SQLException e) {
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
		
		
		public void searchEmployee(int id){
			Connection con=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);
				PreparedStatement pst=con.prepareStatement("Select * from employee where empId=?");
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
					System.out.println("ID: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nDept ID: "
				+rs.getInt(3)+"\nMgr ID: "+rs.getInt(4)+"\nJob Title: "+rs.getString(5));
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

		public void deleteEmployee(int id){
			Connection con=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);
				PreparedStatement pst=con.prepareStatement("Delete from employee where empId=?");
				pst.setInt(1, id);
				int i=pst.executeUpdate();
				if(i>0)
					System.out.println("Deleted");
				else
					System.out.println("Could not delete");
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
		
		/*public void batchEmployee(int id){
			Connection con = null;
		try{
			String query1="Update employee set empName="+, job=? where empId=?"
			
			String query3="Delete from employee where empId="+id;
			Class.forName("com.sql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			Statement stmt=con.createStatement();
			
			int []i=stmt.executeBatch();
			
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
		}*/

}


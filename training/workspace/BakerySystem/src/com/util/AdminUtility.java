package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bean.Items;
import com.bean.Role;
import com.bean.User;

public class AdminUtility extends User {

	public AdminUtility(int userId, Role role, String email, String name,
			String phoneNo, String password) {
		super(userId, role, email, name, phoneNo, password);
		// TODO Auto-generated constructor stub
	}
	

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public void deleteItems() {

		System.out.println("Enter the item code which you wish to delete:");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();

		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			stmt = con.createStatement();
			int checkDel = stmt.executeUpdate("delete from user where id= "
					+ id);
			if (checkDel == 1)
				System.out.println("Deletion done");
			else
				System.out.println("Item does not exist in bakery!");

		} catch (Exception e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end of deleteItems

	public void modifyItems() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the details of the item to modify:-");

		System.out.println("Enter the id of the item:");
		int id = input.nextInt();

		System.out.println("Enter the quantity of the item:");
		int quantity = input.nextInt();
		System.out.println("Enter the price of the item:");
		float price = input.nextFloat();
		System.out.println("Enter the manufacturing date:");
		String s = input.nextLine();
		Date date = null;
		date.valueOf(s);
		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			pst = con
					.prepareStatement("update table items set quantity=?, price=?, mfgDate=? where id=?");

			pst.setInt(1, quantity);
			pst.setFloat(2, price);
			pst.setDate(3, date);
			pst.setInt(4, id);
			int checkDel = pst.executeUpdate();
			if (checkDel > 0)
				System.out.println("Updation done");
			else
				System.out.println("Record does not exist!");

		} catch (Exception e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end of modify

	public void request() {

		// admin will open the orders table and will be able to view all the
		// records with pending, dispatched
		// admin can change the status to approved /rejected
		// cannot see cancelled or delivered or rejected orders

		DataManager dm = new DataManagerImpl();
		try {
			con = dm.getConnection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select * from orders where status in ('Pending', 'Dispatch')");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getNString(2)
						+ rs.getString(3));
				System.out.println("Enter the following for status changes:\n"
						+ "1. Approve the order\n" + "2. Reject the order\n"
						+ "3. Make the status delivered");
				Scanner input = new Scanner(System.in);
				int value = input.nextInt();

				switch (value) {
				case 1:
					pst = con
							.prepareStatement("update table orders set status='Approved' where id=?");

					pst.setInt(1, rs.getInt(1));
					int checkstat = pst.executeUpdate();
					if (checkstat > 0)
						System.out.println("Updation done");
					else
						System.out.println("Record does not exist!");

					break;

				case 2:
					pst = con
							.prepareStatement("update table orders set status='Rejected' where id=?");

					pst.setInt(1, rs.getInt(1));
					int checkstat1 = pst.executeUpdate();
					if (checkstat1 > 0)
						System.out.println("Updation done");
					else
						System.out.println("Record does not exist!");

					break;

				case 3:
					pst = con
							.prepareStatement("update table orders set status='Delivered' where id=?");

					pst.setInt(1, rs.getInt(1));
					int checkstat2 = pst.executeUpdate();
					if (checkstat2 > 0)
						System.out.println("Updation done");
					else
						System.out.println("Record does not exist!");

					break;

				}

			}

		} catch (Exception e) {
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addItem(List<Items> itemList) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the item: ");
		String aname = sc.next();
		boolean flag = false;
		Iterator<Items> it = itemList.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equalsIgnoreCase(aname)) {
				System.out
						.println("Item is already present. Please select the modify option.");
				flag = true;
			}

		}
		if (!flag) {
			System.out.println("Enter the quantity of the item:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int quantity = 0;
			java.sql.Date date=null;
			float price = 0;
			
			try {
				quantity = Integer.parseInt(br.readLine());
				System.out.println("Enter the price of the item:");
				price = Float.parseFloat(br.readLine());
				System.out.println("Enter the manufacturing date:");
				
				String dateStr = br.readLine(); 
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date date1 = sdf.parse(dateStr);
	            date = new java.sql.Date(date1.getTime());  
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Enter the delivery option: ");
			String delOpt = sc.next();
			DataManager dm = new DataManagerImpl();
			int rs;
			try {
				con = dm.getConnection();
				pst=con.prepareStatement("insert into items (name,quantity,price,mfgDate,delOption) values(?,?,?,?,?)");
				pst.setString(1,aname);
				pst.setInt(2, quantity);
				pst.setFloat(3, price);
				pst.setDate(4, date);
				pst.setString(5, delOpt);
				rs=pst.executeUpdate();
				if(rs>0)
				{
					System.out.println("Item added to database.");
				}
				else
				{
					System.out.println("Error in insertion.");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void getTotalSales(){
		DataManager dm=new DataManagerImpl();
		Connection con=null;
		PreparedStatement pst=null;
		
		
	}

}

package com.util;
import com.bean.*;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bean.Items;
import com.bean.Role;
import com.bean.User;
import com.bean.delOption;
import com.exceptions.NotEnoughItems;
import com.exceptions.UserNotFound;

public class CustomerUtil extends User{
	
	public CustomerUtil(int userId, Role role, String email, String name,
			String phoneNo, String password) {
		super(userId, role, email, name, phoneNo, password);
		// TODO Auto-generated constructor stub
	}

	public List<Items> cart = new ArrayList<Items>();

	
	public void buildCart(int uid){
			
			
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			DataManager dm=new DataManagerImpl();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int id;
			int quan;
			
			BakerySystem bs=new BakerySystemImpl();
			
			char ch = 0;
			System.out.println("List of available items are as follows: \n"+bs.populateItems());
			do{
				
				String sql="Select * from items where id=?";
				
				try {
					
					System.out.println("Select item id: (Only items with Home Delivery option can be added to cart.)");
					id=Integer.parseInt(br.readLine());
					con=dm.getConnection();
					stmt=con.prepareStatement(sql);
					stmt.setInt(1, id);
					rs=stmt.executeQuery();
					if(rs.next())
					{
						
						if(rs.getString(6)=="Pickup")
							System.out.println("Not Available for Delivery");
						else{
							Items i=new Items(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), 
									rs.getDate(5), delOption.valueOf(rs.getString(6)));
							System.out.println(i); //Selected Item displayed
							
							System.out.println("Enter Quantity of product you want to buy: ");
							quan=Integer.parseInt(br.readLine());
							
							int quantity1=i.getQuantity()-quan;
							
							if(quantity1<0)
								throw new NotEnoughItems("There are not enough items in the Bakery");
							
							else{
								
									i.setQuantity(quan);   
								  
								 cart.add(i); 
								 System.out.println("Your cart has following items: "+cart);
							} //item added to cart
						}
					}
					else
						throw new UserNotFound("Invalid ID! Please re-enter...");
					
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (UserNotFound e) {
					e.printStackTrace();
				} catch (NotEnoughItems e) {
	
					e.printStackTrace();
				}finally{
					System.out.println("Do you wish to add more items to the Cart? (Y/N):");
					try {
						ch=br.readLine().charAt(0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}while(ch=='y'||ch=='Y');
		
			System.out.println("Your Final cart contains: "+cart);
			System.out.println("Confirm Order? (Y/N): ");
			try {
				ch=br.readLine().charAt(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ch=='y'|ch=='Y')
				confirmOrder(uid);
			else
				cart.clear();
			
	}

	public void confirmOrder(int uid)
	{
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		DataManager dm=new DataManagerImpl();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		float totalAmount=0;
		StringBuilder rec=new StringBuilder();
		String addr;
		int ro;
		try {
			con=dm.getConnection();	
			for(Items i1: cart)	{ 
					
					stmt=con.prepareStatement("Update items set quantity= quantity - ? where id=?");
					stmt.setInt(1, i1.getQuantity());
					stmt.setInt(2, i1.getItemId());
					ro=stmt.executeUpdate();
					if(ro>0){
						System.out.println("Updated database...");
					}
					else{
						System.out.println("Error occurred...");
					}
					totalAmount+=(i1.getPrice()*i1.getQuantity());
					rec.append(i1);
				}		
		
				System.out.println("Enter Address: ");
				addr=br.readLine();
				rec.append("Delivery Address: "+addr);
				
				String receipt=rec.toString();
				
				System.out.println("Total Amount: "+totalAmount);
				
				 Order o=new Order();
				 System.out.println("Enter the date of delivery: Format(YYYY-MM-DD)");
				 String dateStr = br.readLine(); 
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	             java.util.Date date = sdf.parse(dateStr);
	             
	             
	             java.sql.Date delDate = new java.sql.Date(date.getTime());  
				 o.setDate(delDate);
				 o.setAmount(totalAmount);
				 o.setReceipt(receipt);
				 stmt=con.prepareStatement("Insert into orders(receipt, status, amount,id, delDate) values (?,?,?,?,?)");
				 stmt.setString(1, receipt);
				 stmt.setString(2, o.getStatus().toString());
				 stmt.setFloat(3, totalAmount);
				 stmt.setInt(4, uid);
				 stmt.setDate(5, delDate);
				 ro=stmt.executeUpdate();
					if(ro>0){
						System.out.println("Updated database...");
					}
					else{
						System.out.println("Error occurred...");
					}
				 
				 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}	

	 public void checkStatus(User u) {
		 Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			DataManager dm = new DataManagerImpl();
		//	List<Items> itemList = new ArrayList<Items>();
			try {
				rs = stmt.executeQuery("select * from user");
				while (rs.next()) {
					if (rs.getString(2).equals(u.getName())) {
						pst = con.prepareStatement("select * from orders where name = ?");
						pst.setString(1, rs.getString(2));
						ResultSet res = pst.executeQuery();
						while (res.next()) {
							System.out.println("Status of order no : "
									+ rs.getInt(1) + "  is " + rs.getString(3));
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

			
			
		}

public void sortMenu(){
		BakerySystem bs=new BakerySystemImpl();
		
		List<Items> sortedList=new ArrayList<Items>();
		
		sortedList.addAll(bs.populateItems());
		
		Collections.sort(sortedList);
		System.out.println("Sorted Menu: " + sortedList);
		
	}


}

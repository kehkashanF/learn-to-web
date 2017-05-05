package com.psl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Items;
import com.bean.Role;
import com.bean.User;
import com.util.AdminUtility;
import com.util.BakerySystem;
import com.util.BakerySystemImpl;
import com.util.CustomerUtil;

public class Client {
	public static void main(String[] args) {
		BakerySystem bs=new BakerySystemImpl();
		List<Items> items=new ArrayList<Items>();
		items.addAll(bs.populateItems());
		boolean flag=true;
		System.out.println(items);
		do{
		//bs.displayMenu(items);
		//System.out.println(items);
		System.out.println("For registering press r or if you are a returning customer press l\n To logout press any other key");
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine();
		
		if(str.equalsIgnoreCase("r"))
		{
			bs.register();
		}
		else if(str.equalsIgnoreCase("l"))
		{
			User user=bs.validateUser();
			Role r= user.getRole();
			if(r== Role.Admin)
			{
				AdminUtility adm=new AdminUtility(user.getUserId(), user.getRole(), user.getEmail(), user.getName(), user.getPhoneNo(), user.getPassword());
				boolean check=true;
				int ch;
				do{
					System.out.println("\n\nSelect the operation to be performed\n");
					System.out.println("1. Add items\n 2. Delete item\n 3. Modify inventory\n 4. Change request status\n 5. Check total Sales\n 6. Logout");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1: try {
							adm.addItem(items);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					bs.populateItems();
					break;
					case 2: adm.deleteItems();
					bs.populateItems();
					break;
					case 3: adm.modifyItems();
					bs.populateItems();
					break;
					case 4: adm.request();
					break;
					case 6:
						check=false;
						break;
					default: System.out.println("Enter correct choice");
					}
					
				}while(check);
				
			}
			else if(r== Role.Customer)
			{
				int ch;
				boolean check=true;
				
				CustomerUtil cust= new CustomerUtil(user.getUserId(), user.getRole(), user.getEmail(), user.getName(), user.getPhoneNo(), user.getPassword());
				do{
					System.out.println("\n\nSelect the operation to be performed\n");
					System.out.println("1. Place order\n 2. Check status of order\n 3. Sort the menu by Price \n4. Logout\n");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1: cust.buildCart(cust.getUserId());
					bs.populateItems();
					break;
					case 2: cust.checkStatus(cust);
					//bs.populateItems();
					break;
					case 3: cust.sortMenu();
				//	bs.populateItems();
					break;
					case 4: System.out.println("Logging out!! Thank you for coming!");
							check=false;
							break;
					
					default: System.out.println("Enter correct choice");
					}
					
				}while(check);
			}
				
		}
		else
		{
			//continue;
			flag=false;
		}
		
		}
		while(flag);
		
	
		
		

	}
}

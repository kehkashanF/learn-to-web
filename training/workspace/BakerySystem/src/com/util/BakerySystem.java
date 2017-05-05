package com.util;

import java.util.List;

import com.bean.Items;
import com.bean.User;

public interface BakerySystem {

	public List<Items> populateItems();
	public void displayMenu(List<Items> itemList);
	public void register();
	public User validateUser();

}

package com.util;

import java.util.Comparator;

import com.bean.Items;

public class MyCompare implements Comparator<Items>{

	@Override
	public int compare(Items o1, Items o2) {
		
		return (o1.getName().compareToIgnoreCase(o2.getName()));
	}

}

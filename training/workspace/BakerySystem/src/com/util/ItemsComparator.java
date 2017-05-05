package com.util;

import java.util.Comparator;

import com.bean.Items;

public class ItemsComparator implements Comparator<Items> {

	@Override
	public int compare(Items o1, Items o2) {
		Float f1=new Float(o1.getPrice());
		Float f2=new Float(o2.getPrice());
		return f1.compareTo(f2);
	}
		
}

package com.dao;

import com.bean.BloodBank;
import com.bean.Request;

public class BBComparator implements java.util.Comparator<BloodBank>{

	@Override
	public int compare(BloodBank b1, BloodBank b2) {
		// TODO Auto-generated method stub
		return b1.getBloodBank_name().compareTo(b2.getBloodBank_name());
	}

}

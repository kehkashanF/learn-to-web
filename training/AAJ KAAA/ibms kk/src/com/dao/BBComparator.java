package com.dao;

import java.util.Comparator;

import com.bean.BloodBank;
import com.bean.Request;

public class BBComparator implements Comparator<BloodBank>{

	public int compare(BloodBank b1, BloodBank b2) {
		return b1.getBloodBank_name().compareTo(b2.getBloodBank_name());
	}

}

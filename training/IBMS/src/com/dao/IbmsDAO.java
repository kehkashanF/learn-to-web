package com.dao;

import java.util.Map;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.Request;
import com.bean.User;

public interface IbmsDAO {
	public String addhospital(Hospital hospital, User user);

	public String addBloodBank(BloodBank bloodBank, User user);

	public Hospital loginHospital(String username);

	public BloodBank loginBloodBank(String username);

	public int loginUser(User user);
	
	public void acknowledgeRequest(Request request);
	
	public void denyRequest(Request request);
	
	public void contactDonors(BloodBank b, Request request);
	
	public Map<BloodBank, Double> sortByDistance(Map<BloodBank, Double> passedMap);
	
	public void addUser(User user);

}

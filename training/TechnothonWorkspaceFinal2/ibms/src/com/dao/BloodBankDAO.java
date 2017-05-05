package com.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;

import com.bean.BloodBank;
import com.bean.BloodGroup;
import com.bean.BloodType;
import com.bean.Request;

public interface BloodBankDAO {

	public void editDetails(BloodBank bloodBank);
	public List<Request> seeAllRequests(BloodBank bloodBank);
	public void addDonatingDonors(int requestId);
	public List<Request> displayMyRequests(BloodBank bloodBank);
	public void acknowledge(Request r);
	public void deny(Request r);
	public JSONArray seeStock(int bId);
	public JSONArray seeDonors(int bId);
	public String getUnits(BloodBank u, BloodGroup group, BloodType type);
}

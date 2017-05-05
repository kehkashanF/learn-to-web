package com.dao;

import java.util.List;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.Request;

public interface HospitalDAO {
	public List<BloodBank> getAllBloodbanks();
	
	public void addRequest(Request request);
	public void editDetails(Hospital hospital);
	public String cancelRequest(int rId);
	public Request giveRequest(int rId);
	public List<Request> seeCancelledRequests(Hospital hospital);
	public List<Request> seeInProgressRequests(Hospital hospital);
	public List<Request> seeFulfilledRequests(Hospital hospital);
	public List<Request> seeAllRequests(Hospital hospital);
}

package com.dao;

import java.util.List;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.Request;

public interface HospitalDAO {
	public List<BloodBank> getAllBloodbanks();
	public void processRequest(Request request);
	public void addRequest(Request request);
	public void editDetails(Hospital hospital);
}

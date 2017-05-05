package com.dao;

import com.bean.BloodBank;
import com.bean.Hospital;

public interface IbmsDAO {
	public void addhospital(Hospital hospital);

	public void addBloodBank(BloodBank bloodBank);

	public String loginHospital(Hospital hospital);

	
	public String loginBloodBank(BloodBank bloodBank);

}

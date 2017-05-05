package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.Request;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.util.location.AddressConverter;

public class HospitalDAOImpl_template implements HospitalDAO {
	
	private Session getSessionObject(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		return factory.openSession();
	}

	/*
	 * public List<BloodBank> getAllBloodbanks() {
	 * 
	 * String sql = "Select * from blood_banks"; List<Map<String, Object>> list
	 * = jdbcTemplate.queryForList(sql); List<BloodBank> allBloodbanks = new
	 * ArrayList<BloodBank>(); if (list != null && !list.isEmpty()) { for
	 * (Map<String, Object> bloodbanks : list) { BloodBank bloodBank = new
	 * BloodBank(); Object[] ob_arr = new Object[5]; int i = 0; for
	 * (Iterator<Map.Entry<String, Object>> it = bloodbanks.entrySet()
	 * .iterator(); it.hasNext();) { Map.Entry<String, Object> entry =
	 * it.next(); String key = entry.getKey(); ob_arr[i] = entry.getValue();
	 * i++; } bloodBank.setBloodBank_name((String) ob_arr[1]);
	 * bloodBank.setBloodBank_telephoneNo(Integer.parseInt((String)ob_arr[5]));
	 * bloodBank.setBloodBank_url((String)ob_arr[12]);
	 * allBloodbanks.add(bloodBank); } } System.out.println(allBloodbanks);
	 * return allBloodbanks; }
	 */

	public List<BloodBank> getAllBloodbanks() {
		
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		List<BloodBank> bloodBanks = session.createQuery("from BloodBank").list();
		System.out.println(bloodBanks);
		tx.commit();
		session.close();
	
		return bloodBanks;
	}

	public void addRequest(Request request) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		session.save(request);
		tx.commit();
		session.close();
		

	}

	public void editDetails(Hospital hospital) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		session.update(hospital);
		tx.commit();
		session.close();
		
	}

	public void processRequest(Request request) {

		// To fetch the url of the blood bank from the database using hql

		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from BloodBank");
		List<BloodBank> bb = query.list();
		String url = null;
		Client client = Client.create();
		List<BloodBank> list = new ArrayList<BloodBank>();
		for (BloodBank u : bb) {
			url = u.getBloodBank_rest_url();
			// to make a rest call to the requested url
			WebResource resource = client.resource(url);
			Form form = new Form();
			form.add("bloodGroup", request.getBloodgroup());
			form.add("bloodType", request.getBloodType());
			form.add("quantity", request.getQuantity_required());

			ClientResponse res = resource.type(
					MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(
					ClientResponse.class, form);
			String msg = res.getEntity(String.class);
			if (msg.toUpperCase().equals("YES"))
				list.add(u);

		}

		Map<BloodBank, Double> map = new HashMap<BloodBank, Double>();
		AddressConverter ad = null;
		for (BloodBank b : list) {
			double d = ad.calculateDistance(b.getBloodBank_address(), request
					.getHospital().getHospital_address());
			map.put(b, d);
		}

	}

	public List<Request> seeAllRequests(Hospital hospital) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ?");
		query.setInteger(0, hospital.getHospital_id());
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public List<Request> seeFulfilledRequests(Hospital hospital) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and r.status = ?");
		query.setInteger(0, hospital.getHospital_id());
		query.setInteger(1, 5);
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public List<Request> seeInProgressRequests(Hospital hospital) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and (r.status = ? or r.status = ?)");
		query.setInteger(0, hospital.getHospital_id());
		query.setInteger(1, 2);
		query.setInteger(2, 3);
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public List<Request> seeCancelledRequests(Hospital hospital) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and r.status = ?");
		query.setInteger(0, hospital.getHospital_id());
		query.setInteger(1, 4);
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public String cancelRequest(Request request) {
	
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		if (request.getStatus() == 2 || request.getStatus() == 3) {
			request.setStatus(4);
			session.update(request);
			tx.commit();
			session.close();
			return "true";
		}
		return "false";

	}
}

package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.dto.HibernateSessionConnection;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.util.location.AddressConverter;

public class HospitalDAOImpl implements HospitalDAO {
	
	public List<BloodBank> getAllBloodbanks() {
		
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		
		List<BloodBank> bloodBanks = session.createQuery("from BloodBank").list();
		//System.out.println("\n\n\n\n\n\n\nall bloodbanks:"+bloodBanks);
		tx.commit();
		session.close();
	
		return bloodBanks;
	}

	public void addRequest(Request request) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(request);
		tx.commit();
		session.close();
		

	}

	public void editDetails(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.update(hospital);
		tx.commit();
		session.close();
		
	}

	public List<Request> seeAllRequests(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ?");
		query.setInteger(0, hospital.getHospital_id());
		List<Request> listOfRequests = query.list();
		System.out.println(hospital.getHospital_id()+" \n\n\n\n\n\n"+ listOfRequests);
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public List<Request> seeFulfilledRequests(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and r.status = ?");
		query.setInteger(0, hospital.getHospital_id());
//		query.setInteger(1, 5);
		query.setInteger(1, 2);

		List<Request> listOfRequests = query.list();
		Iterator<Request> iterator = listOfRequests.iterator();
		while(iterator.hasNext()){
			Request request =iterator.next();
			if(request.getQuantity_received()!=request.getQuantity_required()){
				iterator.remove();
			}
		}
		tx.commit();
		session.close();
		
		return listOfRequests;
	}
	public List<Request> seeDispatchedRequests(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and r.status = ?");
		query.setInteger(0, hospital.getHospital_id());
		query.setInteger(1, 2);
		List<Request> listOfRequests = query.list();
		Iterator<Request> iterator = listOfRequests.iterator();
		while(iterator.hasNext()){
			Request request =iterator.next();
			if(request.getQuantity_received()==request.getQuantity_required()){
				iterator.remove();
			}
		}
		tx.commit();
		session.close();
		
		return listOfRequests;
	}
	public List<Request> seeInProgressRequests(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.hospital.hospital_id = ? and r.status = ?");
		query.setInteger(0, hospital.getHospital_id());
		query.setInteger(1, 1);
		//query.setInteger(1, 2);
		//query.setInteger(2, 3);
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		
		return listOfRequests;
	}

	public List<Request> seeCancelledRequests(Hospital hospital) {
		Session session = new HibernateSessionConnection().getSession();
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

	public String cancelRequest(int rId) {
		Request request = giveRequest(rId);
		if(request != null){
			Session session = new HibernateSessionConnection().getSession();
			Transaction tx = session.beginTransaction();
			if (request.getStatus() == 2 || request.getStatus() == 3) {
				request.setStatus(4);
				session.update(request);
				return "true";
			}
		}
		return "false";
	}

	public Request giveRequest(int rId) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Request request = (Request) session.get(Request.class, new Integer(rId));
		tx.commit();
		session.close();
		return request;
	}
}

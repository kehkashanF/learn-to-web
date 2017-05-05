package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bean.BloodBank;
import com.bean.BloodGroup;
import com.bean.BloodType;
import com.bean.Hospital;
import com.bean.Request;
import com.dto.HibernateSessionConnection;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class BloodBankDAOImpl implements BloodBankDAO {

	public void editDetails(BloodBank bloodBank) {

		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.update(bloodBank);
		tx.commit();
		session.close();

	}

	public List<Request> seeAllRequests(BloodBank bloodBank) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Request r where r.bloodBank.bloodBank_id = ?");
		query.setInteger(0, bloodBank.getBloodBank_id());
		List<Request> listOfRequests = query.list();
		tx.commit();
		session.close();
		return listOfRequests;
	}

	public void addDonatingDonors(int requestId) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Request request = (Request) session.get(Request.class, new Integer(
				requestId));
		request.setCounter(request.getCounter() + 1);
		session.update(request);
		tx.commit();
		session.close();

	}

	public List<Request> displayMyRequests(BloodBank bloodBank) {

		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		List<Request> requests = session.createQuery(
				"from Request R where R.bloodBank=" + bloodBank
						+ " and R.viewed=false").list();
		tx.commit();
		session.close();
		return requests;

	}

	public void acknowledge(Request r) {
		String url = null;
		Client client = new Client();
		// yaha blood bank ka object banana hai jiski details update hona
		// hai
		// viewed also needs to be updated
		// if(staticrequests.contains(r))
		// {
		// staticrequests.remove(r);
		// }
		// r.setViewed(true);
		//
		// staticrequests.add(r);

		IbmsDAOImpl id = new IbmsDAOImpl();
		id.acknowledgeRequest(r);
		BloodBank BloodBank = r.getBloodBank();
		url = BloodBank.getBloodBank_rest_url();
		WebResource resource = client.resource(url + "/updateStock");
		Form form = new Form();
		form.add("bloodGroup", r.getBloodgroup());
		form.add("bloodType", r.getBloodType());
		form.add("quantity", r.getQuantity_received());
		ClientResponse res = resource.type(
				MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(
				ClientResponse.class, form);
	}

	public void deny(Request r) {

		r.setViewed(true);
		IbmsDAOImpl id = new IbmsDAOImpl();
		id.denyRequest(r);
	}

	public JSONArray seeStock(int bId) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		BloodBank bloodBank = (BloodBank) session.get(BloodBank.class,
				new Integer(bId));
		tx.commit();
		session.close();
		Client client = Client.create();
		WebResource resource = client.resource(bloodBank
				.getBloodBank_rest_url() + "/getStock");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String responseData = response.getEntity(String.class);
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(responseData);

		} catch (JSONException e1) {

			e1.printStackTrace();
		}

		return jsonArray;
	}

	public JSONArray seeDonors(int bId) {
		Session session = new HibernateSessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		BloodBank bloodBank = (BloodBank) session.get(BloodBank.class,
				new Integer(bId));
		tx.commit();
		session.close();
		Client client = Client.create();
		WebResource resource = client.resource(bloodBank
				.getBloodBank_rest_url() + "/getAllDonors");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String responseData = response.getEntity(String.class);
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(responseData);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			}

		} catch (JSONException e1) {

			e1.printStackTrace();
		}

		return jsonArray;
	}

	public String getUnits(BloodBank u, BloodGroup group, BloodType type) {
		u.getBloodBank_rest_url();
		String url = u.getBloodBank_rest_url();
		url = url + "/getUnitsAvailable";
		Client client = Client.create();
		WebResource resource = client.resource(url);
		Form form = new Form();
		form.add("bloodGroup", group);
		form.add("bloodType", type);

		ClientResponse res = resource.type(
				MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(
				ClientResponse.class, form);
		String msg = res.getEntity(String.class);
		return msg;
	}

}
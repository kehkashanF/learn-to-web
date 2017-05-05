package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.bean.BloodBank;
import com.bean.Hospital;
import com.bean.Request;
import com.bean.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.twilio.sdk.TwilioRestException;
import com.util.Email;
import com.util.SmsSender;
import com.util.location.AddressConverter;

import java.io.IOException;
import java.sql.Date;

public class IbmsDAOImpl implements IbmsDAO {
	Map<BloodBank, Double> map_yes;
	Map<BloodBank, Double> map_yesAll;
	Map<BloodBank, Double> map;

	public void addUser(User user) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(User.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		factory.close();

	}

	public String addhospital(Hospital hospital, User user) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Hospital.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Hospital where hospital_email = ? or hospital_lisenceNo = ?");
		query.setParameter(0, hospital.getHospital_email());
		query.setParameter(1, hospital.getHospital_lisenceNo());
		List<Hospital> listOfHospitals = query.list();
		if (listOfHospitals.size() == 0) {

			session.saveOrUpdate(hospital);
			addUser(user);
			tx.commit();
			session.close();
			factory.close();
			return "true";
		}

		tx.commit();
		session.close();
		factory.close();
		return "false";

	}

	public String addBloodBank(BloodBank bloodBank, User user) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from BloodBank where bloodBank_emailId = ? or FDA_lisenceNo = ?");
		query.setParameter(0, bloodBank.getBloodBank_emailId());
		query.setParameter(1, bloodBank.getFDA_lisenceNo());
		List<BloodBank> listOfBloodBanks = query.list();
		if (listOfBloodBanks.size() == 0) {
			session.saveOrUpdate(bloodBank);
			addUser(user);
			tx.commit();
			session.close();
			factory.close();
			return "true";
		}
		tx.commit();
		session.close();
		factory.close();
		return "false";
	}

	public int loginUser(User user) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(User.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> users = session.createQuery("from User").list();
		for (User us : users) {
			if ((us.getEmail().equals(user.getEmail()))
					&& (us.getPassword().equals(user.getPassword()))) {
				tx.commit();
				session.close();
				factory.close();
				return us.getRole();
			}

		}

		tx.commit();
		session.close();
		factory.close();
		return -1;
	}

	public Hospital loginHospital(String username) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Hospital.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from Hospital where hospital_email = ?");
		query.setParameter(0, username);
		List<Hospital> hospitals = query.list();
		// new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
		// be written in the Controller
		for (Hospital hospital : hospitals) {
			tx.commit();
			session.close();
			factory.close();
			return hospital;

		}

		tx.commit();
		session.close();
		factory.close();
		return null;
	}

	public BloodBank loginBloodBank(String username) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from BloodBank where bloodBank_emailId = ?");
		query.setParameter(0, username);
		List<BloodBank> bbs = query.list();
		// new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
		// be written in the Controller
		for (BloodBank bb : bbs) {
			tx.commit();
			session.close();
			factory.close();
			return bb;

		}

		tx.commit();
		session.close();
		factory.close();
		return null;
	}

	// public String loginBloodBank(BloodBank bloodBank) {
	// SessionFactory factory = new AnnotationConfiguration().configure()
	// .addAnnotatedClass(BloodBank.class).buildSessionFactory();
	// Session session = factory.openSession();
	// Transaction tx = session.beginTransaction();
	// List<BloodBank> bloodBanks = session.createQuery("from BloodBank")
	// .list();
	// // new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
	// // be written in the Controller
	// for (BloodBank bB : bloodBanks) {
	// if (bB.getBloodBank_emailId().equalsIgnoreCase(
	// bloodBank.getBloodBank_emailId())) {
	// tx.commit();
	// session.close();
	// factory.close();
	// return "true";
	// }
	//
	// }
	//
	// return "false";
	//
	// }

	public void processRequest(Request request) {

		// To fetch the url of the blood bank from the database using hql

		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from BloodBank");
		List<BloodBank> bb = query.list();
		String url = null;
		Client client = Client.create();
		AddressConverter ad = new AddressConverter();
		map = new HashMap<BloodBank, Double>();
		List<BloodBank> list_yes = new ArrayList<BloodBank>();
		List<BloodBank> list_yesAll = new ArrayList<BloodBank>();
		for (BloodBank u : bb) {
			// System.out.println(u.getBloodBank_address()+" vhfgahj       \t\t\t\t\t\t"
			// + request.getHospital().getHospital_address());

			double d = 0;
			try {
				d = ad.calculateDistance(u.getBloodBank_address(), request
						.getHospital().getHospital_address());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(u, d);// calculate the distance of each blood bank and store
							// it in a map
			// to make a rest call to the requested url
			url = u.getBloodBank_rest_url();
			url = url + "/checkAvailability";
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
				list_yes.add(u);
			else if (msg.toUpperCase().equals("YESALL"))
				list_yesAll.add(u);

		}

		map_yes = new HashMap<BloodBank, Double>();
		map_yesAll = new HashMap<BloodBank, Double>();

		if (list_yes.size() == 0 && list_yesAll.size() == 0) {
			map = sortByDistance(map);
			BloodBank key1 = (BloodBank) map.keySet().toArray()[0];
			request.setBloodBank(key1);
			HospitalDAO obj=new HospitalDAOImpl();
			obj.addRequest(request);
			contactDonors(key1, request);
			SmsSender sms=new SmsSender();
			String message="Your donors are being contacted";
			String message2="We are contacting donors.";
			try {
				sms.sendMessage("+91"+request.getBloodBank().getBloodBank_mobileNo().toString(), message);
				sms.sendMessage("+91"+request.getHospital().getHospital_contactNo().toString(), message2);
				
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			if (list_yesAll.size() != 0) {
				for (BloodBank b : list_yesAll) {
					map_yesAll.put(b, map.get(b));// all the blood bank and its
													// corresponding distances
													// is placed in a map
				}
				map_yesAll = sortByDistance(map_yesAll);

			}
			for (BloodBank b : list_yes) {

				map_yes.put(b, map.get(b));// all the blood bank and its
											// corresponding distances is placed
											// in a map
			}
			map_yes = sortByDistance(map_yes);
		}

		if (map_yesAll.size() != 0) {
			BloodBank key1 = (BloodBank) map_yesAll.keySet().toArray()[0];
			// int quantity=key1.get
			request.setBloodBank(key1);
			
			HospitalDAO obj=new HospitalDAOImpl();
			obj.addRequest(request);
			SmsSender sms=new SmsSender();
			String message="You will receive sample from hospital for requestId:"+request.getRequestId();
			String message2="XYZ will come before 5PM to collect blood sample for requestId:+"+request.getRequestId();
			try {
				sms.sendMessage("+91"+key1.getBloodBank_mobileNo().toString(), message);
				sms.sendMessage("+91"+request.getHospital().getHospital_contactNo().toString(), message2);
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			BloodBank key1 = (BloodBank) map_yes.keySet().toArray()[0];
			request.setBloodBank(key1);
			
			
			url = key1.getBloodBank_rest_url();
			url = url + "/getQuantity";
			WebResource resource = client.resource(url);
			Form form = new Form();
			form.add("bloodGroup", request.getBloodgroup());
			form.add("bloodType", request.getBloodType());

			ClientResponse res = resource.type(
					MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(
					ClientResponse.class, form);
			String msg = res.getEntity(String.class);
			int quantity_received=Integer.parseInt(msg);
			request.setQuantity_received(quantity_received);
			
			HospitalDAO obj=new HospitalDAOImpl();
			obj.addRequest(request);
			SmsSender sms=new SmsSender();
			String message="You will receive sample from hospital for requestId:"+request.getRequestId()+" Also contact donors for the same.";
			String message2="XYZ will come before 5PM to collect blood sample for requestId:+"+request.getRequestId();
			try {
				sms.sendMessage("+91"+key1.getBloodBank_mobileNo().toString(), message);
				sms.sendMessage("+91"+request.getHospital().getHospital_contactNo().toString(), message2);
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public void acknowledgeRequest(Request request) {
		request.setViewed(true);
		request.setStatus(2);
		HospitalDAO obj=new HospitalDAOImpl();
		obj.addRequest(request);
		SmsSender sms=new SmsSender();
		String message="A person will be coming to collect the blood for requestId:"+request.getRequestId();
		String message2="You will receive the required blood by 6PM today";
		try {
			sms.sendMessage("+91"+request.getBloodBank().getBloodBank_mobileNo().toString(), message);
			sms.sendMessage("+91"+request.getHospital().getHospital_contactNo().toString(), message2);
			
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map_yesAll.containsKey(request.getBloodBank())) {
			request.setQuantity_received(request.getQuantity_required());
		}
		else if(map_yes.containsKey(request.getBloodBank())) {
			contactDonors(request.getBloodBank(), request);
		}
	}

	public void denyRequest(Request request) {

		contactDonors(request.getBloodBank(),request);
		SmsSender sms=new SmsSender();
		String message="Your donors are being contacted";
		String message2="We are contacting donors.";
		try {
			sms.sendMessage("+91"+request.getBloodBank().getBloodBank_mobileNo().toString(), message);
			sms.sendMessage("+91"+request.getHospital().getHospital_contactNo().toString(), message2);
			
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if (map_yesAll.containsKey(b)) {
			map_yesAll.remove(b);
			if (map_yesAll.size() >= 0) {
				BloodBank key1 = (BloodBank) map_yesAll.keySet().toArray()[0];
				request.setBloodBank(key1);
				HospitalDAO obj=new HospitalDAOImpl();
				obj.addRequest(request);
			} else {
				if (map_yes.size() >= 0) {
					BloodBank key1 = (BloodBank) map_yes.keySet().toArray()[0];
					request.setBloodBank(key1);
					HospitalDAO obj=new HospitalDAOImpl();
					obj.addRequest(request);
					// check stock
				} else {
					contactDonors(b, request);
				}
			}
		} else if (map_yes.containsKey(b)) {
			map_yes.remove(b);
			if (map_yes.size() >= 0) {
				BloodBank key1 = (BloodBank) map_yes.keySet().toArray()[0];
				request.setBloodBank(key1);
				HospitalDAO obj=new HospitalDAOImpl();
				obj.addRequest(request);
				// check stock
			} else {
				contactDonors(b, request);
			}
		}*/
		
	}

	public void contactDonors(BloodBank b, Request request) {
		Client client = Client.create();
		String url_first = b.getBloodBank_rest_url() + "/contactDonor";
		WebResource resource = client.resource(url_first);
		Form form = new Form();
		String date = request.getDelivery_date_time();
		String[] dateToArray = date.split("/");
		Date sqlDate = Date.valueOf(dateToArray[2] + "-" + dateToArray[0] + "-"
				+ dateToArray[1]);
		form.add("bloodGroup", request.getBloodgroup());
		form.add("date", sqlDate);
		form.add("requestId", request.getRequestId());
		form.add("bloodBankId", b.getBloodBank_id());
		ClientResponse res = resource.type(
				MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(
				ClientResponse.class, form);
		String msg = res.getEntity(String.class);
	}

	public Map<BloodBank, Double> sortByDistance(
			Map<BloodBank, Double> passedMap) {
		List mapKeys = new ArrayList(passedMap.keySet());
		List mapValues = new ArrayList(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys, new Comparator<BloodBank>() {

			public int compare(BloodBank o1, BloodBank o2) {
				// TODO Auto-generated method stub
				return o1.getBloodBank_name().compareTo(o2.getBloodBank_name());
			}

		});
		Map<BloodBank, Double> sortedMap = new LinkedHashMap<BloodBank, Double>();

		Iterator valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Object val = valueIt.next();
			Iterator keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Object key = keyIt.next();
				String comp1 = passedMap.get(key).toString();
				String comp2 = val.toString();

				if (comp1.equals(comp2)) {
					passedMap.remove(key);
					mapKeys.remove(key);
					sortedMap.put((BloodBank) key, (Double) val);
					break;
				}

			}

		}
		return sortedMap;
	}


}

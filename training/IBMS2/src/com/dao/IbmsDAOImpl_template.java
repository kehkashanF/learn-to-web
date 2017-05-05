package com.dao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.util.location.AddressConverter;

public class IbmsDAOImpl_template implements IbmsDAO {

	public void addhospital(Hospital hospital) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Hospital.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(hospital);
		tx.commit();
		session.close();
		factory.close();

	}

	public void addBloodBank(BloodBank bloodBank) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(bloodBank);
		tx.commit();
		session.close();
		factory.close();
	}

	public String loginHospital(Hospital hospital) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Hospital.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Hospital> hospitals = session.createQuery("from Hospital").list();
		// new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
		// be written in the Controller
		for (Hospital hosp : hospitals) {
			if (hosp.getHospital_email().equalsIgnoreCase(
					hospital.getHospital_email())) {
				if (hosp.getHospital_password().equals(
						hospital.getHospital_password()))
					return "Login successful";
				else
					return "Password is incorrect";

			}

		}

		tx.commit();
		session.close();
		factory.close();
		return "Email-id is incorrect";
	}

	public String loginBloodBank(BloodBank bloodBank) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<BloodBank> bloodBanks = session.createQuery("from BloodBank").list();
		// new SHA().getSHA1SecurePassword(hospital.getHospital_password()); To
		// be written in the Controller
		for (BloodBank bB : bloodBanks) {
			if (bB.getBloodBank_emailId().equalsIgnoreCase(
					bloodBank.getBloodBank_emailId())) {
				if (bB.getBloodBank_password().equals(
						bloodBank.getBloodBank_password()))
					return "Login successful";

				else
					return "Password is incorrect";
			}

		}
		tx.commit();
		session.close();
		factory.close();
		return "Email-id is incorrect";

	}
public void processRequest(Request request) {
		
		//To fetch the url of the blood bank from the database using hql
		
		Configuration configuration=new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tx= session.beginTransaction();
		Query query=session.createQuery("from BloodBank");
		List<BloodBank> bb=query.list();
		String url=null;
		Client client=Client.create();
		AddressConverter ad=null;
		Map<BloodBank,Double> map=new HashMap<BloodBank,Double>();
		List<BloodBank> list_yes=new ArrayList<BloodBank>();
		List<BloodBank> list_yesAll=new ArrayList<BloodBank>();
		for(BloodBank u:bb){
			
			
			double d=ad.calculateDistance(u.getBloodBank_address(), request.getHospital().getHospital_address());
			map.put(u,d);//calculate the distance of each blood bank and store it in a map
			//to make a rest  call to the requested url
			url=u.getBloodBank_rest_url();
			url=url+"/checkAvailability";
			WebResource resource=client.resource(url);
			Form form = new Form();
			form.add("bloodGroup", request.getBloodgroup());
			form.add("bloodType",request.getBloodType());
			form.add("quantity",request.getQuantity_required());
			
			ClientResponse res=resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class,form);
			String msg=res.getEntity(String.class);
			if(msg.toUpperCase().equals("YES"))
				list_yes.add(u);
			else if(msg.toUpperCase().equals("YESALL"))
				list_yesAll.add(u);
			
		}
		
		Map<BloodBank,Double> map_yes=new HashMap<BloodBank,Double>();
		Map<BloodBank,Double> map_yesAll=new HashMap<BloodBank,Double>();
		
		if(list_yes.size()==0&&list_yesAll.size()==0){
			sortByDistance(map);
			BloodBank key1=(BloodBank) map.keySet().toArray()[0];
			String url_first=key1.getBloodBank_rest_url()+"/contactDonor";
			WebResource resource=client.resource(url);
			Form form = new Form();
			form.add("bloodGroup", request.getBloodgroup());
			form.add("date",request.getDelivery_date_time());
			form.add("url",request.getBloodBank().getBloodBank_url());//YE CHEEZ ANKITA KAREGI
			
			ClientResponse res=resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class,form);
			String msg=res.getEntity(String.class);//request has been sent
		}
		else if(list_yesAll.size()!=0){
			for(BloodBank b:list_yesAll){
				map_yesAll.put(b, map.get(b));//all the blood bank and its corresponding distances is placed in a map
			}
			 sortByDistance(map_yesAll);
			 //request.setS
		}
		else{
		for(BloodBank b:list_yes){
			
			map_yes.put(b, map.get(b));//all the blood bank and its corresponding distances is placed in a map
		}
		sortByDistance(map_yes);
		}
//	map.get(key)
		
	}

public void sortByDistance(Map<BloodBank,Double> map){
	Set<Entry<BloodBank, Double>> set = map.entrySet();
    List<Entry<BloodBank, Double>> list1 = new ArrayList<Entry<BloodBank, Double>>(set);
    Collections.sort( list1, new Comparator<Map.Entry<BloodBank, Double>>()
    {
        public int compare( Map.Entry<BloodBank, Double> o1, Map.Entry<BloodBank, Double> o2 )
        {
            return (o1.getValue()).compareTo( o2.getValue() );//blood banks are sorted in increasing order of their distances
        }
    } );
}

	

	

}

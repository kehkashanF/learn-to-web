package com.psl.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Donor;
import com.psl.bean.StockItem;
import com.psl.util.SmsSender;
import com.psl.util.TinyURL;
import com.twilio.sdk.TwilioRestException;

public class BloodBankDAO {

	private Session getSessionObject() {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		return factory.openSession();
	}

	public String checkIfAvailable(String bloodGroup, String bloodType,
			int quantity) {
		System.out.println("Bloodgroup :"+bloodGroup+" bloodtype :"+bloodType);
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		List<StockItem> list = session.createQuery("from StockItem").list();
		System.out.println("\t\t\t\t\t List "+list);
		for (StockItem stockItem : list) {
			System.out.println(stockItem);
			if (stockItem.getBloodGroup().toString()
					.equalsIgnoreCase(bloodGroup)
					&& stockItem.getBloodType().toString()
							.equalsIgnoreCase(bloodType)) {
				double quantity2 = quantity * 0.25;
				if (stockItem.getQuantity() >= quantity) {
					tx.commit();
					session.close();
					return "YESALL";
				} else if (stockItem.getQuantity() >= quantity2) {
					tx.commit();
					session.close();

					return "YES";
				}
			}

		}
		tx.commit();
		session.close();
		return "NO";
	}

	@SuppressWarnings("deprecation")
	public void contactDonor(String bloodGroup, Date date, int requestId,
			int bloodBankId) {
		String url = "http://localhost:8080/IBMS/available.jsp";
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Donor");
		List<Donor> donors = query.list();
		java.util.Date currentDate = new java.util.Date(); // 15-12-2015
		String message = "";
		if (date.getDate() == currentDate.getDate()
				&& date.getMonth() == currentDate.getMonth()
				&& date.getYear() == date.getYear()) {
			message = "Urgent need for " + bloodGroup
					+ " blood today. Click to confirm: ";

		} else {

			java.util.Date utilDate = new java.util.Date(date.getYear(),
					date.getMonth(), date.getDate());
			Date oneDayBefore = new Date(utilDate.getTime()
					- (24 * 60 * 60 * 1000));
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			message = "Need for " + bloodGroup + " blood on "
					+ df.format(oneDayBefore) + " . Click to confirm: ";
		}

		for (Donor donor : donors) {
			SmsSender sms = new SmsSender();
			if (donor.getBloodGroup().toString().equalsIgnoreCase(bloodGroup)) {
				try {
					message = message
							+ new TinyURL().getUrl(url + "?rId=" + requestId
									+ "&bId=" + bloodBankId + "&dId="
									+ donor.getDonor_id());
					sms.sendMessage(donor.getContactNo(), message);
				} catch (TwilioRestException e) {
					e.printStackTrace();
				}
			}
		}
		tx.commit();
		session.close();
	}

	public void updateStock(String bloodGroup, String bloodType, int quantity) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from StockItem");
		List<StockItem> list = query.list();
		for (StockItem stockItem : list) {
			if (stockItem.getBloodGroup().toString()
					.equalsIgnoreCase(bloodGroup)
					&& stockItem.getBloodType().toString()
							.equalsIgnoreCase(bloodType)) {
				stockItem.setQuantity(stockItem.getQuantity() - quantity);
				session.update(stockItem);

			}
			tx.commit();
			session.close();
		}

	}

	public List<Donor> getAllDonors() {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		List<Donor> listOfDonors = session.createQuery("from Donor").list();

		tx.commit();
		session.close();
		System.out.println(listOfDonors);
		return listOfDonors;
	}

	public List<StockItem> getStockAvailable() {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		List<StockItem> listOfStock = session.createQuery("from StockItem")
				.list();
		tx.commit();
		session.close();
		System.out.println(listOfStock);
		return listOfStock;
	}

	public String getQuantity(String bloodGroup, String bloodType) {
		Session session = getSessionObject();
		Transaction tx = session.beginTransaction();
		List<StockItem> list = session.createQuery("from StockItem").list();
		for (StockItem stockItem : list) {
			if (stockItem.getBloodGroup().toString()
					.equalsIgnoreCase(bloodGroup)
					&& stockItem.getBloodType().toString()
							.equalsIgnoreCase(bloodType)) {

				tx.commit();
				session.close();
				return "" + stockItem.getQuantity();

			}

		}
		tx.commit();
		session.close();
		return "" + 0;
	}

}

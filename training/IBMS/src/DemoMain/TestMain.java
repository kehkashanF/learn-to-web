package DemoMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bean.BloodBank;
import com.bean.BloodGroup;
import com.bean.BloodType;
import com.bean.Hospital;
import com.bean.Request;

public class TestMain {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(BloodBank.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		BloodBank bank = new BloodBank("bloodBank_name", "ramdaspeth nagpur",
				413512, " bloodBank_circle", "bloodBank_telephoneNo",
				"bloodBank_mobileNo", "fDA_lisenceNo", "bTO_name", true,
				"bloodBank_emailId", "bloodBank_password", "bloodBank_url",
				"bloodBank_rest_url");
		session.save(bank);

		tx.commit();
		session.close();
		factory.close();
		/*
		 * 
		 * 
		 * 
		 * @SuppressWarnings("deprecation") SessionFactory factory = new
		 * AnnotationConfiguration().configure()
		 * .addAnnotatedClass(BloodBank.class).buildSessionFactory(); Session
		 * session = factory.openSession(); Transaction tx =
		 * session.beginTransaction();
		 * 
		 * BloodBank bank = new BloodBank("bloodBank_name", "bloodBank_address",
		 * 413512, " bloodBank_circle", "bloodBank_telephoneNo",
		 * "bloodBank_mobileNo", "fDA_lisenceNo", "bTO_name", true,
		 * "bloodBank_emailId", "bloodBank_password", "bloodBank_url",
		 * "bloodBank_rest_url"); session.save(bank);
		 * 
		 * tx.commit(); session.close(); factory.close();
		 * 
		 * factory = new AnnotationConfiguration().configure()
		 * .addAnnotatedClass(Hospital.class).buildSessionFactory(); session =
		 * factory.openSession(); tx = session.beginTransaction();
		 * 
		 * Hospital hospital = new Hospital("hospital_name", "hospital_address",
		 * 440067, "hospital_password", "hospital_lisenceNo", "officer_name",
		 * "hospital_email", "hospital_certification", "hospital_contactNo");
		 * 
		 * session.save(hospital);
		 * 
		 * tx.commit(); session.close(); factory.close();
		 * 
		 * factory = new AnnotationConfiguration().configure()
		 * .addAnnotatedClass(Request.class).buildSessionFactory(); session =
		 * factory.openSession(); tx = session.beginTransaction();
		 * 
		 * 
		 * 
		 * /*session.save(request);
		 */
		/*
		 * tx.commit(); session.close(); factory.close();
		 */
	}
}

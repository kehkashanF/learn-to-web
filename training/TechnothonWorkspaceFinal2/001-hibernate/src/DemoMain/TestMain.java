package DemoMain;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.psl.bean.BloodGroup;
import com.psl.bean.BloodType;
import com.psl.bean.Donor;
import com.psl.bean.StockItem;
import com.sun.research.ws.wadl.Request;

public class TestMain {
	public static void main(String[] args) {

		@SuppressWarnings("deprecation")
		SessionFactory factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(StockItem.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		StockItem stockItem = new StockItem(BloodGroup.A_NEGATIVE,
				BloodType.FFP, 25);
		session.save(stockItem);
		stockItem = new StockItem(BloodGroup.A_POSITIVE, BloodType.WB, 56);
		session.save(stockItem);
		tx.commit();
		session.close();
		factory.close();

		factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Donor.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		Donor donor = new Donor("donor_name", new Date(0, 0, 0), "female",
				BloodGroup.B_NEGATIVE, "emailId", "9665339257",
				"donor_address", "city", new Date(0));
		session.save(donor);

		tx.commit();
		session.close();
		factory.close();

		factory = new AnnotationConfiguration().configure()
				.addAnnotatedClass(Request.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();

		/* session.save(request); */

		tx.commit();
		session.close();
		factory.close();

	}
}

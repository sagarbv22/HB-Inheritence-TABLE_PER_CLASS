package in.ineuron.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.entity.CardPayment;
import in.ineuron.entity.Payment;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		try {

			session = HibernateUtil.getSession();

			Payment payment = session.get(Payment.class, 12);

			CardPayment cardPayment = session.get(CardPayment.class, 12);
			System.out.println(cardPayment);
			// it doesn't support polymorphism, beoz the properties from parent class is not
			// retrieving...
		
			System.out.println(payment);
			System.out.println("_____________________________");
			Query query = session.createQuery("FROM in.ineuron.entity.Payment");
			List list = query.getResultList();
			
			list.forEach(System.out::println);
			
			Query query2 = session.createQuery("FROM in.ineuron.entity.CardPayment");
			List list2 = query2.getResultList();
			
			list2.forEach(System.out::println);
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

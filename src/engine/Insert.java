package engine;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.*;

public class Insert {
	
	public static void insert(Object o) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Instructor_detail.class)
							.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			System.out.println("insert::error" + o.toString());
			System.out.println(e);
			session.close();
		}
		factory.close();
	}
	
	public static void insert(Object o, SessionManager s) {
		s.generateFactory();
		s.generateSession();
		Session session = s.getSession();
		try {
			session.beginTransaction();
			session.persist(o);
			session.getTransaction();
			s.endSession();
		}
		catch(Exception e) {
			System.out.println("insert::error");
			System.out.println(e);
			s.endSession();
		}
		s.endFactory();
	}
	
	public static void insert(List<Object> o, SessionManager s)
	{
		s.generateFactory();
		s.generateSession();
		s.getSession().beginTransaction();
		for(Object object : o)
		{
			try {
				s.getSession().persist(object);
			}
			catch(Exception e) {
				System.out.println("insert::error");
				System.out.println(e);
			}
		}
		s.getSession().getTransaction().commit();;
		s.endSession();
		s.endFactory();
	}
	

}
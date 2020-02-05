package engine;

import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.*;

import entity.*;

public class Delete {

	public static void delete(Object o) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor_detail.class)
						.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(o);
			session.getTransaction();
			session.close();
		}
		catch(Exception e) {
			System.out.println("delete::error");
			System.out.println(e);
			session.close();
		}
		factory.close();
	}
	
	public static void deleteById(Object o, int id) {
		SessionFactory factory = (SessionFactory) new Configuration()
			.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor_detail.class)
					.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		if(o.getClass() == Instructor.class) {
			try {
				session.beginTransaction();
				ArrayList<Instructor> objectRemoved = new ArrayList<Instructor>();
				if(objectRemoved != null) {
					session.remove(objectRemoved.get(0));
				}
				session.getTransaction().commit();
				session.close();
			}
			catch(Exception e) {
				System.out.println("delete::instructor::error");
				System.out.println(e);
				session.close();
			}
		}
		if(o.getClass() == Instructor_detail.class) {
			try {
				session.beginTransaction();
				ArrayList<Instructor_detail> objectRemoved = new ArrayList<Instructor_detail>();
				if(objectRemoved != null) {
					session.remove(objectRemoved.get(0));
				}
				session.getTransaction().commit();
				session.close();
			}
			catch(Exception e) {
				System.out.println("delete::instructor_detail::errror");
				System.out.println(e);
				session.close();
			}
		}
		if(o.getClass() == Course.class) {
			try {
				session.beginTransaction();
				ArrayList<Course> objectRemoved = new ArrayList<Course>();
				if(objectRemoved != null) {
					session.remove(objectRemoved.get(0));
				}
				session.getTransaction().commit();
				session.close();
			}
			catch(Exception e) {
				System.out.println("delete::course::error");
				System.out.println(e);
				session.close();
			}
			
		}
		if(o.getClass() == Review.class) {
			try {
				session.beginTransaction();
				ArrayList<Review> objectRemoved = new ArrayList<Review>();
				if(objectRemoved != null) {
					session.remove(objectRemoved.get(0));
				}
				session.getTransaction().commit();
				session.close();
			}
			catch(Exception e) {
				System.out.println("delete::review::error");
				System.out.println(e);
				session.close();
			}
		}
		if(o.getClass() == Student.class) {
			try {
				session.beginTransaction();
				ArrayList<Student> objectRemoved = new ArrayList<Student>();
				if(objectRemoved != null) {
					session.remove(objectRemoved.get(0));
				}
				session.getTransaction().commit();
				session.close();
			}
			catch(Exception e) {
				System.out.println("delete::student::error");
				System.out.println(e);
				session.close();
			}
		}
		factory.close();
	}
}

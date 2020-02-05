package engine;

import org.hibernate.*;
import org.hibernate.cfg.*;

import entity.*;

public class SessionManager {
	private static SessionFactory factory;
	private static Session session;
	
	public SessionManager() {}
	
	public void generateFactory(){
		this.setFactory((SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Instructor_detail.class)
							.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
										.buildSessionFactory());
	}
	
	public void generateSession() {
		session = factory.getCurrentSession();
	}
	
	public void endSession() {
		  this.getSession().close();
	}
	
	public void endFactory() {
		this.getFactory().close();
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}

package sp.sree.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import sp.sree.model.Student;

//util class -> static members, not allow to create object
public class HibernateUtil 
{
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil()
	{
		
	}
	
	//session factory object is required only one time throughout the application
	static
	{
		//if we are not interested in giving the mapping inforation in xml file, then we can attach it while creating sessionFactory object
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public static Session getSession()
	{
		if(sessionFactory != null)
			session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void closeSession(Session session)
	{
		if(session != null)
			session.close();
	}
	
	public static void closeSessionFactory()
	{
		if(sessionFactory != null)
			sessionFactory.close();
	}
}

package sp.sree.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sp.sree.model.Student;

public class TestApp 
{
	public static void main(String[] args) 
	{
		//1. Inform JVM to activate Hibernate S/W (passing configuration file)
		Configuration configuration = new Configuration();
		configuration.configure(); //if the file name is 'hibernate.cfg.xml', then no need to pass the file name
		
		//Creating SessionFactory object to hold many internal objects required for HIBERNATE
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//Using SessionFactory obj, get only one session obj to oerform our persistence operation
		Session session = sessionFactory.openSession(); //it contains L1-cache, connection obj, ORM-dialect, TXTMAnagement
			
		//whenever we are working with non-select operatrion, transaction management is required
		Transaction transaction = session.beginTransaction();
		
		//2. Create Persistence Object
		Student student = new Student();
		student.setSid(1001);
		student.setSname("Sreevishnu");
		student.setSage(12);
		student.setScity("Kakinada");
				
		//3. Perform Persistence Operation using Entity/Model/POJO object
		session.save(student);
		
		//all the operations done wrt our object will not done directly in jdbc, it will be done in Cache
		
		//Generate the query and send to database for execution
		transaction.commit();
		
		System.out.println("Object saved to database");
		
		session.close();
		sessionFactory.close();
	}
}

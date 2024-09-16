package sp.sree.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sp.sree.model.Student;
import sp.sree.util.HibernateUtil;

public class SaveApp 
{
	public static void main(String[] args) 
	{
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try
		{
			session = HibernateUtil.getSession();
			
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) 
			{
				Student std = new Student();
				std.setSid(1003);
				std.setSname("Uma Maheswara Rao");
				std.setSage(53);
				std.setScity("Kakinada");
				
				session.save(std);
				
				check = true; //till he if everything happend without any exceptions, we will commit the transaction, so that insert operation will be performed by JDBC
			}
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(check)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

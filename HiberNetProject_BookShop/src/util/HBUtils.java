package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HBUtils {
	
	private static SessionFactory sessionFactory;
	
	static
	{
	ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HBUtils.sessionFactory = sessionFactory;
	}
	
	public static void beginTransaction()
	{
		sessionFactory.getCurrentSession().getTransaction().begin();
	}
	
	public static void commitTransaction()
	{
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction()
	{
		sessionFactory.getCurrentSession().getTransaction().rollback();
	}

}

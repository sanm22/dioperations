package com.logitech.operationmart.utils;

 
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {

	private static final SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		
		
		ServiceRegistry register = new StandardServiceRegistryBuilder().configure("./hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(register).getMetadataBuilder().build();
		return metadata.getSessionFactoryBuilder().build();
		

	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public void shutDown() {
		getSessionFactory().close();
	}
}

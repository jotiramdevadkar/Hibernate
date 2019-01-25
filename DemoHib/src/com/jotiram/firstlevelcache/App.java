package com.jotiram.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	public static void main(String[] args) {
		
		Alien a=null;
		
		Configuration con =new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session1=sf.openSession();
		
		session1.beginTransaction();
		a=(Alien) session1.get(Alien.class, 1);
		System.out.println(a);
		
		a=(Alien) session1.get(Alien.class, 1);
		System.out.println(a);
		
		session1.getTransaction().commit();
	}

}

package com.jotiram.demohib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {
	
	public static void main(String[] args) {
		
		AlienName an=new AlienName();
		an.setFname("Ram");
		an.setMname("Soudager");
		an.setLname("Dev");
		
		Alien obj=new Alien();
		
		obj.setAid(102);
		obj.setAname(an);
		obj.setColor("green");
		
		
		Configuration con= new Configuration().configure().addAnnotatedClass(Alien.class); 
		
		ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		
		Session session =sf.openSession();
		
		Transaction  tx=session.beginTransaction();
		
//		obj =(Alien) session.get(Alien.class, 102);
		
		session.save(obj);
		tx.commit();
		
		System.out.println(obj);
		
	}

}

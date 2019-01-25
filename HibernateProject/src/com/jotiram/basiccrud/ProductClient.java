package com.jotiram.basiccrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jotiram.util.HibernateUtil;

public class ProductClient {

	public Product save(Product product) {
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session =sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		
		return product;
	}
	
	
	public Product getProductById(int id) {
		System.out.println("Fetching Product By id:"+id);
		
		Session session=HibernateUtil.getSession();
		
		Transaction transaction=session.beginTransaction();
		Product product=(Product) session.get(Product.class, id);
		
		transaction.commit();
		session.close();
		return product;
	}
	
	public void update(Product product) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}
	
	public void delete(int id)
	{
		System.out.println("deleting Product id :"+id);
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		Product product=getProductById(id);
		
		if(product == null)
		{
			System.out.println("Product Not Found");
			return;
		}
		else {
			session.delete(product);
			transaction.commit();
			session.close();
			System.out.println("Delete SucessFully");
		}
	}
}

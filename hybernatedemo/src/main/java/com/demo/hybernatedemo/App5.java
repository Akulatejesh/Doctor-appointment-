package com.demo.hybernatedemo;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import com.demo.hybernatedemo.config.HibernateUtility;
import com.demo.hybernatedemo.entities.Product;
 
public class App5 {
 
	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtility.getSessionFactoryObject();
		 Product prd=new Product();
		 prd.setPrdName("Hibernate");
		 //prd.setPrdCategory("Book");
		 prd.setPrdPrice(1700);
		 Session session=sessionFactory.openSession();
		 Transaction trnx=session.beginTransaction();
		 session.persist(prd);
		 System.out.println("Product created with id :" + prd.getPrdId());
		 trnx.commit();
		 session.close();
	}
 
}
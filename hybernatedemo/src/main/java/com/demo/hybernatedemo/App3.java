package com.demo.hybernatedemo;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
 
import com.demo.hybernatedemo.config.HibernateUtility;
 
public class App3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtility.getSessionFactoryObject();
		 Session session=sessionFactory.openSession();
		 //Query query=session.createQuery("from Product p where p.prdCategory=?1");
		 @SuppressWarnings({ "deprecation", "unchecked" })
		Query<Object[]> query=session.createQuery("select p.prdId,p.prdName from Product p where p.prdCategory=?1");
	 query.setParameter(1, "Toy");
	// List<Product> products=query.getResultList();
		 List<Object[]> products=query.getResultList();
		// products.forEach((System.out::println));
		 for(Object[] prd:products) {
			 for(Object o:prd)
			  System.out.println(o);
		 } 
		 session.close();
}
}
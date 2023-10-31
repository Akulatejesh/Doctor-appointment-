package com.demo.hybernatedemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import com.demo.hibernatedemo1.config.HibernateUtility;
import com.demo.hibernatedemo1.entities.Perfume;
public class App {
  public static void main(String[] args) {
	  SessionFactory sessionFactory=HibernateUtility.getSessionFactoryObject();
   Perfume prdObj=new Perfume(1,"KS","DARE",700);
   Perfume prdObj1=new Perfume(2,"DENVER","PRIDE",500);
   Perfume prdObj2=new Perfume(3,"BRUTE","URGE",2000);
    Session session=sessionFactory.openSession();
  Transaction trnx= session.beginTransaction();
  session.save(prdObj2);
   trnx.commit();
  session.close();
   System.out.println(prdObj2);
  }
}
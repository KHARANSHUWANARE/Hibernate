package com.myproject;



import org.hibernate.*;

import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "application started" );
        
        Configuration configuration = new Configuration();
        
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        System.out.println(sessionFactory);
        
        com.myproject.Student student = new com.myproject.Student();
        
        student.setCityString("nagpur");
        
        student.setId(1);
        
        student.setNameString("pratik");
       Session session=sessionFactory.openSession();
       
       Transaction transaction=session.beginTransaction();
       
       session.save(student);
       
       transaction.commit();
       
       session.close();
       
       	
       
       
       
    }
}

package com.myproject.EmbedDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myproject.Certificate;
import com.myproject.Student;

public class EmbedDemo {

	public static void main(String[] args) {
		System.out.println("application started");

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Certificate certificate = new Certificate();

		certificate.setCoursenameString("java full stack");

		certificate.setDurationString("6 months");

		Student student = new Student();

		student.setId(1);

		student.setNameString("pratik");

		student.setCityString("nagpur");

		student.setCertificate(certificate);

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(student);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
	

	}

}

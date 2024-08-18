package com.myproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		
		try {
			
			//fetch using get method
			Student student = (Student) session.get(Student.class, 1);

			if (student == null) {
				System.out.println("Student not found");
			} else {
				System.out.println(student);
			}

			//fetch using load method  
			Address address = (Address) session.load(Address.class, 1);

			if (address == null) {
				System.out.println("Address not found");
			} else {
				System.out.println(address);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();

		}

	}

}

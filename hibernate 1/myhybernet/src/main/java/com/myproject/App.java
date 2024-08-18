package com.myproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.hibernate.*;

import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("application started");

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		System.out.println(sessionFactory);

		com.myproject.Student student = new com.myproject.Student();

		student.setCityString("nagpur");

		student.setId(1);

		student.setNameString("pratik");

		Address address = new Address();

		address.setStreetString("hingna");

		address.setCityString("nagpur");

		address.setOpen(true);

		address.setX(88.96);

		LocalDate localDate = LocalDate.now();

		address.setAdddateDate(localDate);

		// add image in db

		try {
			// file input stram throws filenotfound exception
			FileInputStream fileInputStream = new FileInputStream("src/main/java/one.jpg");
			try {
				// byte throws ioexception
				byte[] imageInByte = new byte[fileInputStream.available()];
				fileInputStream.read(imageInByte);
				address.setImages(imageInByte);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		try {

			session.save(student);

			session.save(address);

			transaction.commit();

			session.close();

		} catch (Exception e) {
		
			transaction.rollback();

			System.out.println(e);
		}

		finally {
			session.close();

		}

	}
}

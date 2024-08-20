package com.myproject.mappingdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("application started");

		//configarating
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		//sessionfactory creation
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		System.out.println(sessionFactory);
		
		//creating question object 
		Question question = new Question();
		
		question.setQuestion("what is java");
		
		question.setQuestionId(1212);
		
		//creating answer object		
		Answer answer = new Answer();
		answer.setAnswer("java is programming language");
		answer.setAnswerId(343);
		answer.setQuestion(question);
		
		question.setAnswer(answer);
		
		//opening new session
		Session session=sessionFactory.openSession();		
		
		Transaction transaction =session.beginTransaction();
		
		//save object in session
		session.persist(question);
		session.persist(answer);
		
		
		//commit changes
		transaction.commit();
		
		//fetch with id primary key
		Question question2 = session.get(Question.class, 1212);
		
		System.out.println(question2);
		
		
		//close session
		session.close();
		
		//close session factory
		sessionFactory.close();

	}

}

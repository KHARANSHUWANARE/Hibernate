package com.myproject.oneToManyMappingDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		System.out.println("application started");

		// configarating
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		// sessionfactory creation

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		System.out.println(sessionFactory);

		List<Answer> list = new ArrayList<Answer>();

		Question question = new Question();

		question.setQid(1);
		question.setQuestionString("what is java?");

		Answer answer = new Answer();

		answer.setAid(111);
		answer.setAnswerString("java is programming language");
		answer.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAid(112);
		answer2.setAnswerString("java has many framework");
		answer2.setQuestion(question);

		Answer answer3 = new Answer();
		answer3.setAid(113);
		answer3.setAnswerString("java is a high level language");
		answer3.setQuestion(question);
 
		list.add(answer);
		list.add(answer2);
		list.add(answer3);

		question.setAnswers(list);

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		
		session.persist(answer);
		session.persist(answer2);
		session.persist(answer3);

		session.persist(question);

		transaction.commit();

		sessionFactory.close();

	}

}

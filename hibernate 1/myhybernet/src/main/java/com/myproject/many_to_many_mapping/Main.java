package com.myproject.many_to_many_mapping;

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

		Employee employee = new Employee();
		employee.setEid(1);
		employee.setEmpname("pratik");

		Employee employee1 = new Employee();
		employee.setEid(2);
		employee.setEmpname("kharanshu");

		Employee employee2 = new Employee();
		employee.setEid(3);
		employee.setEmpname("manthan");

		Employee employee3 = new Employee();
		employee.setEid(4);
		employee.setEmpname("wanare");

		Project project = new Project();

		project.setPid(111);
		project.setProjectname("java devlopment");

		Project project2 = new Project();

		project.setPid(112);
		project.setProjectname(".net devlopment");

		List<Project> list = new ArrayList<Project>();
		list.add(project);
		list.add(project2);

		List<Project> list2 = new ArrayList<Project>();
		list2.add(project2);

		employee.setProjects(list);

		employee3.setProjects(list);

		employee1.setProjects(list2);

		employee2.setProjects(list2);

		ArrayList<Employee> arrayList = new ArrayList<Employee>();

		arrayList.add(employee);
		arrayList.add(employee2);

		ArrayList<Employee> arrayList1 = new ArrayList<Employee>();

		arrayList1.add(employee1);
		arrayList1.add(employee3);

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(employee);
		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);

		session.persist(project);

		session.persist(project2);
		transaction.commit();
		session.close();

		sessionFactory.close();
	}
}

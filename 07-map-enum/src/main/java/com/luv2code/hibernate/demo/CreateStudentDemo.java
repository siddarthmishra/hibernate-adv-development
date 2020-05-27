package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Status;
import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// create the object
			Student student1 = new Student("John", "Doe", "john@love2code.com", Status.ACTIVE);
			Student student2 = new Student("Tony", "Stark", "tony@avengers.com", Status.INACTIVE);

			// start a transaction
			transaction = session.beginTransaction();

			// save the object
			System.out.println("Saving.....");
			session.persist(student1);
			session.persist(student2);

			// commit the transaction
			transaction.commit();
			System.out.println("Done!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// clean up code
			session.close();
			factory.close();
		}
	}

}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.Student;

public class CreateStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// create the object
			// User user = new User("Mary", "Public", "mary@love2code.com");
			Student student = new Student("John", "Doe", "john@love2code.com", "Hibernate");
			Instructor instructor = new Instructor("Tony", "Stark", "tony@avengers.com", 20000.00);

			// start a transaction
			transaction = session.beginTransaction();

			// save the object
			System.out.println("Saving.....");
			// session.persist(user);
			session.persist(student);
			session.persist(instructor);

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

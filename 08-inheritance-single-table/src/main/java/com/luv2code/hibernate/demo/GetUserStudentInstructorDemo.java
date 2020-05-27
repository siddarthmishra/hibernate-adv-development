package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.Student;
import com.luv2code.hibernate.entity.User;

public class GetUserStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// start a transaction
			transaction = session.beginTransaction();

			for (int id = 1; id <= 3; id++) {
				// get the id
				User user = session.get(User.class, id);

				// print the detail
				System.out.println("\nDetails for Id : " + id + "\n" + user);
				System.out.println("======================================================");
			}

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

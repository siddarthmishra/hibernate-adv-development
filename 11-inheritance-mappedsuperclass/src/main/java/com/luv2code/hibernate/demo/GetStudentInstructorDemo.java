package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.Student;

public class GetStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// start a transaction
			transaction = session.beginTransaction();

			int id = 1;

			// get the id
			Student student = session.get(Student.class, id);

			// print the detail
			System.out.println("\nStudent Details for Id : " + id + "\n" + student);
			System.out.println("======================================================");

			// get the id
			Instructor instructor = session.get(Instructor.class, id);

			// print the detail
			System.out.println("\nInstructor Details for Id : " + id + "\n" + instructor);
			System.out.println("======================================================");

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

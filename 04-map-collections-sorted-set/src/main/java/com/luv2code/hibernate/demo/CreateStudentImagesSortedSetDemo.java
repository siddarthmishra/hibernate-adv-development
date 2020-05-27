package com.luv2code.hibernate.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentImagesSortedSetDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// create the object
			Student student = new Student("John", "Doe", "john@luv2code.com");
			Set<String> images = student.getImages();

			images.add("image1.jpg");
			images.add("image2.jpg");
			images.add("image3.jpg");
			images.add("image4.jpg");
			images.add("image4.jpg");
			images.add("image5.jpg");

			// start a transaction
			transaction = session.beginTransaction();

			// save the object
			System.out.println("Saving the student and images...");
			session.persist(student);

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

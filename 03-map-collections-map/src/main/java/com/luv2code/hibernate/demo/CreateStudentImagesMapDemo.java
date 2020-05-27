package com.luv2code.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentImagesMapDemo {

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
			Map<String, String> images = student.getImages();

			images.put("photo1.jpg", "Photo 1");
			images.put("photo2.jpg", "Photo 2");
			images.put("photo3.jpg", "Photo 3");
			images.put("photo4.jpg", "Photo 4");

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
			transaction.rollback();
		} finally {
			// clean up code
			session.close();
			factory.close();
		}
	}

}

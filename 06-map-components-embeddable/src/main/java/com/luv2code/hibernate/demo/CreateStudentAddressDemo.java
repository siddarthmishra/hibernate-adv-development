package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Address;
import com.luv2code.hibernate.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		Transaction transaction = null;

		try {
			// create the object
			Student student = new Student("Tony", "Stark", "tony@avengers.com");

			// create Address object
			Address homeAddress = new Address("Home Street", "Home City", "123456");
			Address billingAddress = new Address("Billing Street", "Billing City", "789123");

			// set the address objects to student object
			student.setHomeAddress(homeAddress);
			student.setBillingAddress(billingAddress);

			// start a transaction
			transaction = session.beginTransaction();

			// save the object
			System.out.println("Saving.....");
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

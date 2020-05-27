package com.luv2code.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "com.luv2code.hibernate.entity.Student")
//@DiscriminatorValue is OPTIONAL
//Default value will be class name i.e 'Student' in this case
public class Student extends User {

	private String course;

	public Student() {
	}

	public Student(String firstName, String lastname, String email, String course) {
		super(firstName, lastname, email);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return super.toString() + "\nStudent [course=" + course + "]";
	}
}

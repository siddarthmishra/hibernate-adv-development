package com.luv2code.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "com.luv2code.hibernate.entity.Instructor")
//@DiscriminatorValue is OPTIONAL
//Default value will be class name i.e 'Instructor' in this case
public class Instructor extends User {

	private Double salary;

	public Instructor() {
	}

	public Instructor(String firstName, String lastname, String email, Double salary) {
		super(firstName, lastname, email);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + "\nInstructor [salary=" + salary + "]";
	}
}

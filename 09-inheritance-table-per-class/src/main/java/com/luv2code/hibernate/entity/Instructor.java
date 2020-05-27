package com.luv2code.hibernate.entity;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue is not required when using TABLE_PER_CLASS strategy
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

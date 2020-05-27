package com.luv2code.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @Inheritance is OPTIONAL. default is SINGLE_TABLE
@DiscriminatorColumn(name = "USER_TYPE", length = 255)
@DiscriminatorValue(value = "com.luv2code.hibernate.entity.User")
// @DiscriminatorColumn & @DiscriminatorValue is OPTIONAL
// @DiscriminatorColumn -> Default column name will be DTYPE
// @DiscriminatorValue -> Default value will be class name i.e 'User' in this case
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	public User() {
	}

	public User(String firstName, String lastname, String email) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + "]";
	}
}

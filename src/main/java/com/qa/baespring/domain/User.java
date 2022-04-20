package com.qa.baespring.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "firstName", "lastName", "username" }) })
public class User {
	
	@Id // This makes the column a Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This makes this column auto-increment
	private long id;
	
	// Creates a column called "firstname"
	// This column CAN NOT be null
	@Column(name = "firstname", nullable = false)
	private String firstName;
	
	// Creates a column called "last_name"
	// This column CAN NOT be null
	@Column(nullable = false)
	private String lastName;
	
	// Creates a column called "username"
	// username MUST be unique (no duplicates)
	@Column(unique = true, nullable = false)
	private String username;
	
	// Default Constructor
	public User() {}
	
	// Used for creating/inserting
	public User(String firstName, String lastName, String username) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	// Used for reading/selecting (and testing)
	public User(long id, String firstName, String lastName, String username) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(username, other.username);
	}
}

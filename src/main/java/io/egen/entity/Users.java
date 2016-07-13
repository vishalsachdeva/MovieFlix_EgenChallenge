package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_user")
@NamedQueries ({
		@NamedQuery(name="Users.findUserByEmailId", query="SELECT u FROM Users u WHERE u.email = :email"),
		@NamedQuery(name="Users.findUserByEmailAndPassword", query="SELECT u FROM Users u WHERE u.email = :email AND u.password = :password ")
})

public class Users {
	
	@Id
	@GenericGenerator(strategy = "uuid2",name = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

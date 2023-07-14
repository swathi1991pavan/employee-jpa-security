package com.example.employee.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column (name="Id")
	private int id;
	
	@Column (name="Name" ,nullable=false, length=50)
	@NotEmpty(message = "user name shouldn't be null")
	@Size(min = 3,max=50 , message= "Size should be between 3 to 50")
	private String name;
	
	@Column (name="Email" )
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid email address")
	private String email;
	
	@Column (name="Password" , nullable=false )
	
	private String password; 
	 
	private String roles;
	
	
	public UserInfo() { }
	
	public UserInfo(int id,
			@NotEmpty(message = "user name shouldn't be null") @Size(min = 3, max = 50, message = "Size should be between 3 to 50") String name,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "invalid email address") String email,
			@NotEmpty(message = "shouldn't be null") @Size(min = 3, max = 50, message = "Size should be between 3 to 50") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles=roles;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	

}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


import org.springframework.lang.NonNull;



@Entity
@Table(name="employee")
public class Employee {
	


	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@NonNull
	@Size(min=2,message="first name should have atleast 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NonNull
	@Size(min=2,message="last name should have atleast 2 characters")
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(columnDefinition = "boolean default false")    
	  private Boolean locked;
	
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	@NonNull
	@Email
	@Column(name="email_address")
	private String emailid;
	
	@NonNull
	@Size(min=5,message="passport should have atleast 5 characters")
	@Column(name="passport_number")
	private String passportNumber;
	public Employee() {

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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Employee(long id, @Size(min = 2, message = "first name should have atleast 2 characters") String firstName,
			@Size(min = 2, message = "last name should have atleast 2 characters") String lastName,
			@Email String emailid,
			@Size(min = 5, message = "passport should have atleast 5 characters") String passportNumber) {
		
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName; 	
		this.emailid = emailid;
		this.passportNumber = passportNumber;
		
	}
	
	
}
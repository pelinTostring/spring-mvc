package com.pelin.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table()
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","company"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar (50)")
	private String firstName;
	
	@Column(columnDefinition = "varchar (50)")
	private String lastName;
	
	@Column(columnDefinition = "varchar")
	private String email;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email, Company company) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}

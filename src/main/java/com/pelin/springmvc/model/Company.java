package com.pelin.springmvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table()
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar")
	private String companyName;
	
	@Column(columnDefinition = "varchar")
	private String webSite;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	List<Employee> employees;
	
	public Company() {
		
	}
	
	public Company(int id, String companyName, String webSite, List<Employee> employees) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}

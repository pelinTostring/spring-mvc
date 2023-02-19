package com.pelin.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.pelin.springmvc.model.Company;


public interface CompanyService {
	Company add(Company company);
	Company getById(int companyId);
	String delete(int id);
	Optional<Company> update(int id, Company company);
	List<Company>getAll();
}

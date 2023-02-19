package com.pelin.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pelin.springmvc.model.Company;
import com.pelin.springmvc.repository.CompanyRepository;
import com.pelin.springmvc.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public Company add(Company company) {
		companyRepository.save(company);
		return company;
	}

	@Override
	public Company getById(int companyId) {
		return companyRepository.findById(companyId).get();
	}

	@Override
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	@Override
	public String delete(int id){
		companyRepository.deleteById(id);
		return "Company id: " + id + " deleted";
	}

	@Override
	public Optional<Company> update(int id, Company company) {
		Optional<Company> companyData = companyRepository.findById(id);

		if (companyData.isPresent()) {
			Company comp = companyData.get();
			company.setCompanyName(company.getCompanyName());
			company.setWebSite(company.getWebSite());
			company.setEmployees(company.getEmployees());
			companyRepository.save(comp);
		}
		return Optional.of(company);
	}
}

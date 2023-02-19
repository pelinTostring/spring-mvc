package com.pelin.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pelin.springmvc.model.Company;
import com.pelin.springmvc.model.Employee;
import com.pelin.springmvc.repository.EmployeeRepository;
import com.pelin.springmvc.service.CompanyService;
import com.pelin.springmvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{	
	
	private final EmployeeRepository employeeRepository;
	private final CompanyService companyService;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyService companyService) {
		this.employeeRepository = employeeRepository;
		this.companyService = companyService;
	}

	@Override
	public Employee add(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Optional<Employee> getById(int id) {
		return Optional.of(employeeRepository.findById(id).orElseThrow());
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public String delete(int id) {
		employeeRepository.deleteById(id);
		return "Employee id: " + id + " deleted";
	}

	@Override
	public Optional<Employee> update(int id, Employee employee) {
		Optional<Employee>employeeData = employeeRepository.findById(id);
		
		if (employeeData.isPresent()) {
			Employee emp = employeeData.get();
			emp.setCompany(employee.getCompany());
			emp.setEmail(employee.getEmail());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			employeeRepository.save(emp);
		}
		return Optional.empty();
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyService.getAll();
	} 
	
}

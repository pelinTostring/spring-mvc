package com.pelin.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.pelin.springmvc.model.Company;
import com.pelin.springmvc.model.Employee;


public interface EmployeeService {
	Employee add(Employee employee);
	Optional<Employee> getById(int id);
	List<Employee>getAll();
	String delete(int id);
	Optional<Employee> update(int id, Employee employee);
	List<Company> getAllCompanies();
}

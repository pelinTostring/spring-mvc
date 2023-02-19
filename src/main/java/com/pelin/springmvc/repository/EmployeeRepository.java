package com.pelin.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelin.springmvc.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
